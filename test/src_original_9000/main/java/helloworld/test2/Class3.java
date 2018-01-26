package helloworld.test2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Class3 {
// < this is where we put the class CodeViz line to log data >

	public Class3(String something){
		System.out.println(something);
		method1("hello from class3 method1");
        // Auto-Populated CodeViz Code
        File codeVizLogFile = new File("C:\\Users\\pnadolny\\Documents\\Personal_Development\\GitHub\\CodeViz\\test\\src_CodeVizLog\\CodeVizLog_7878.txt") ;
        BufferedWriter wr = new BufferedWriter(new FileWriter(codeVizLogFile, true));
        wr.write("method1 from Class3 was executed");
        wr.newLine();
        wr.close();
		
	}
	public void method1(String print) {
        // Auto-Populated CodeViz Code
        File codeVizLogFile = new File("C:\\Users\\pnadolny\\Documents\\Personal_Development\\GitHub\\CodeViz\\test\\src_CodeVizLog\\CodeVizLog_7878.txt") ;
        BufferedWriter wr = new BufferedWriter(new FileWriter(codeVizLogFile, true));
        wr.write("method1 from Class3 was executed");
        wr.newLine();
        wr.close();
		System.out.println(print);
	}
}
