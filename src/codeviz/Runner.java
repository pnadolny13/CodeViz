package codeviz;

public class Runner {
	// user inputs -- start /path/to/src/dir
	// or stop.. or restart
	public static void main(String[] args) throws Exception {
		String command = args[0];
		String path = null;
		if (command.equals("start") || command.equals("stop")) {
			path = args[1];
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
