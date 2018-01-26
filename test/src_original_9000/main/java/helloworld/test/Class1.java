package helloworld.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Class1 {
// < this is where we put the class CodeViz line to log data >

	public Class1(String something){
		System.out.println(something);
		method1("hello from class1 method1");
        // Auto-Populated CodeViz Code
        File codeVizLogFile = new File("C:\\Users\\pnadolny\\Documents\\Personal_Development\\GitHub\\CodeViz\\test\\src_CodeVizLog\\CodeVizLog_7878.txt") ;
        BufferedWriter wr = new BufferedWriter(new FileWriter(codeVizLogFile, true));
        wr.write("method1 from Class1 was executed");
        wr.newLine();
        wr.close();
		
	}
	public void method1(String print) {
        // Auto-Populated CodeViz Code
        File codeVizLogFile = new File("C:\\Users\\pnadolny\\Documents\\Personal_Development\\GitHub\\CodeViz\\test\\src_CodeVizLog\\CodeVizLog_7878.txt") ;
        BufferedWriter wr = new BufferedWriter(new FileWriter(codeVizLogFile, true));
        wr.write("method1 from Class1 was executed");
        wr.newLine();
        wr.close();
		System.out.println(print);
	}
}
