package codeviz;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Start {
	public Start() {
		// do something
	}

	public void run(String srcPath, String tempLocation, String versionID) throws IOException {
		// copy src to temp location
		File srcFileDir = new File(srcPath);
		File tempFileDir = new File(tempLocation);
		if (!tempFileDir.exists()) {
			tempFileDir.mkdirs();
		} else {
			// uh oh we need to figure out a new temp dir??
		}
		File codeVizLogDir = new File(srcPath + "_CodeVizLog");
		if (!codeVizLogDir.exists()) {
			codeVizLogDir.mkdirs();
		} else {
			// uh oh we need to figure out a new temp dir??
		}

		// copy src dir to temp dir
		FileUtils.copyDirectory(srcFileDir, tempFileDir);

		
		// create CodeViz log file to put all code output
		Random rand = new Random();
		String codeVizLogFile =  codeVizLogDir + "\\CodeVizLog_" + versionID + ".txt";
		File codeVizLogs = new File(codeVizLogFile);
		codeVizLogs.createNewFile();
		
		
		// validate copy happened then kick off the updating of code

		iterateDirectory(tempFileDir, codeVizLogFile);
		
		// change src to tempFile name plus original
		File orignalSrc_temp = new File(srcPath+ "_original_" + versionID);
		File codeVizSrcVersion = new File(srcPath);
		srcFileDir.renameTo(orignalSrc_temp);

		
		// change tempFile name to srcFile name
		tempFileDir.renameTo(codeVizSrcVersion);		
		

	}

	public void iterateDirectory(File directoryName, String codeVizLogFile) throws IOException {
		File[] directoryListing = directoryName.listFiles();
		File codeVizLogFile1 = new File(codeVizLogFile);
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				if (child.isDirectory()) {
					iterateDirectory(child, codeVizLogFile);
				}
				if (child.toString().endsWith(".java")) {
					LineIterator it = FileUtils.lineIterator(child, "UTF-8");
					String tempLoc = child.toString().replace(".java", "_temp.java");
					File tempFile = new File(tempLoc);
					tempFile.createNewFile();
					BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile, true));
					// wr.write("test");
					try {
						String className = "";
						String methodName = "";
						while (it.hasNext()) {
							String line = it.nextLine();
							// find class declaration
							if (line.contains("public class") || line.contains("protected class") || line.contains("private class")) {
								String[] contents = line.split(" ");
								for (int i = 0; i < contents.length; i++) {
									// System.out.println("class contents " + contents[i]);
									if (contents[i].equals("class")) {
										className = contents[i + 1];
										System.out.println(className);
									}
								}
								String codeVizLine = "// < this is where we put the class CodeViz line to log data >";
								wr.write("import java.io.BufferedWriter;");
								wr.newLine();
								wr.write("import java.io.File;");
								wr.newLine();
								wr.write("import java.io.FileWriter;");
								wr.newLine();
								wr.newLine();
								// add throws IOException before the close bracket
								wr.write(line);
								wr.newLine();
								wr.write(codeVizLine);
								wr.newLine();
							}
							// if the line is a method, set method name
							else if (line.contains("method1")) {
								methodName = "method1";
								String codeVizLine = "\"" + methodName + " from " + className + " was executed" + "\"";
								// add throws IOException before the close bracket
								wr.write(line);
								wr.newLine();
								wr.write("        // Auto-Populated CodeViz Code");
								wr.newLine();
								wr.write("        File codeVizLogFile = new File(\"" + codeVizLogFile.toString().replace("\\", "\\\\") + "\") ;");
								wr.newLine();
								wr.write("        BufferedWriter wr = new BufferedWriter(new FileWriter(codeVizLogFile, true));");
								wr.newLine();
								wr.write("        wr.write(" + codeVizLine + ");");
								wr.newLine();
								wr.write("        wr.newLine();");
								wr.newLine();
								wr.write("        wr.close();");
								wr.newLine();


							} else {
								wr.write(line);
								wr.newLine();
							}

						}
					} finally {
						it.close();
						wr.close();
					}
					// swap original file for updated temp file
					child.delete();
					tempFile.renameTo(child);
				}
			}
		}
	}
}
