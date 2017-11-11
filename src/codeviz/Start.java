package codeviz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Start {
	public Start() {
		// do something
	}

	public void run(String srcPath, String tempLocation) throws IOException {
		// copy src to temp location
		File srcFileDir = new File(srcPath);
		File tempFileDir = new File(tempLocation);
		if (!tempFileDir.exists()) {
			tempFileDir.mkdirs();
		} else {
			// uh oh we need to figure out a new temp dir??
		}

		// copy src dir to temp dir
		FileUtils.copyDirectory(srcFileDir, tempFileDir);

		// validate copy happened then kick off the updating of code

		iterateDirectory(tempFileDir);
		// Iterator it = FileUtils.iterateFiles(new File("C:/"), null, false);
		// while(it.hasNext()){
		// System.out.println(((File) it.next()).getName());
		// }

	}

	public void iterateDirectory(File directoryName) throws FileNotFoundException {
		File[] directoryListing = directoryName.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				if (child.isDirectory()) {
					iterateDirectory(child);
				}
				if (child.toString().endsWith(".java")) {
					try {
						BufferedReader reader = new BufferedReader(new FileReader(child));
						String line;
						while ((line = reader.readLine()) != null)
							;
						{
							// if line includes method or class then write it to log
							System.out.println(line);
						}
						reader.close();
					} catch (Exception e) {
						System.err.format("Exception occurred trying to read '%s'.", child);
						e.printStackTrace();
					}
				}
			}
		}
	}
}
