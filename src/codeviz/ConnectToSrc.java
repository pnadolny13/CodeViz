package codeviz;

import java.io.File;
import java.util.Random;


public class ConnectToSrc {

	public ConnectToSrc() {
		// TODO Auto-generated constructor stub
	}

	public void execute(String command, String path) throws Exception {
		//String action = determineAction(command);
		
		//validate path exists
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception("path doesn't exist!");
		};		
		
		// determine temp location
		String tempLocation = tempPath(path);

		
		if (command.equals("start")) {
			// pass both variables to start class
			//create copy using the new temp location
			Start start = new Start();
			start.run(path, tempLocation);
			
		}
		else if (command.equals("stop")) {
			// pass both variables to stop class
			Stop stop = new Stop();
			stop.run(path, tempLocation);
		}
		else {
			//restart
			// nothing for now
		}
	}
	
	public String tempPath(String path){
		// determine a temp path or find where it exists already
		Random rand = new Random();
		return path + "_CodeViz_" + rand.nextInt(10000);
	}

//	public String determineAction(String command) {
//		String action = "";
//		if (command.equals("start")) {
//			// start
//		}
//		else if (command.equals("stop")) {
//			// stop
//		}
//		else {
//			//restart
//		}
//		return action;
//	}
}
