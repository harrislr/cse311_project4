package project4;
import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.core.dom.*;



public class Main {

	public static void main(String[] args) throws IOException {
//		System.out.println(new File("Visitor.java").getAbsoluteFile());
		String file = Parser.readFromFile("src/project4/Visitor.java");
		Parser.parse(file);
		System.out.println(Visitor.declarations);
		System.out.println(Visitor.usages);
	}

}
