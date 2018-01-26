package codeviz;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Stop {
	public Stop() {
		// do something
	}
	public void run(String srcPath) throws IOException{
		// TODO check to make sure there is an original directory before we delete
		
		// get original file path
		// list all directories next to the src... find the one that has _original_ in it...keep the number as versionID
		// get one up directory
		String[] list1 = srcPath.split("\\\\");
		String toRemove = list1[(list1.length)-1];
		String upOneSrcPath = srcPath.substring(0, srcPath.length()-toRemove.length());
		String versionID = "";
		
		File upOneSrcPathFile = new File(upOneSrcPath);
		File[] directoryListing = upOneSrcPathFile.listFiles();
		
		// iterate directory list and find original
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				System.out.println(child);
				if (child.getName().contains("_original_")) {
					String[] list = child.getName().split("_");
					versionID = list[(list.length)-1];
					break;
				}
			}
		}

		
		// take src file from srcPath and delete it
		File srcFile_codeviz_enabled = new File(srcPath);
		File srcFile_original = new File(srcPath + "_original_" + versionID);
		File temp_for_renaming = new File(srcPath + "_tempforrenaming_");
				
		// rename current src file to a temp name
		// srcFile_codeviz_enabled.renameTo(temp_for_renaming);
		FileUtils.deleteDirectory(srcFile_codeviz_enabled);
		
		// rename original src file to the src name
		File srcFile = new File (srcPath);
		srcFile_original.renameTo(srcFile);
		
		// delete code viz version
		//temp_for_renaming.delete();
	
	}
}
