package codeviz;

public class Run extends Utility {
	// user inputs -- start /path/to/src/dir
	// or stop.. or restart
	public static void runs(String command, String path) throws Exception {
//		String command = args[0];
		if (command.equals(START) || command.equals(STOP)) {
//			path = args[1];
			if (path == null) {
				throw new Exception("Need to define path to your src code directory!");
			}
		ConnectToSrc run = new ConnectToSrc();
		run.execute(command, path);
		}else {
			throw new Exception("Commands not recogized! Check the manual.");
		}
	}

}
