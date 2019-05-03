package project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Parser {

	public static Visitor parse(String fileName, String fileContents) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(fileContents.toCharArray());
		final CompilationUnit cu = (CompilationUnit)parser.createAST(null);
		Visitor vis = new Visitor(cu, fileName);
		cu.accept(vis);
		return vis;
	}
	
	public static String readFromFile(String filename) throws IOException {
		StringBuilder builder = new StringBuilder();
		FileReader fReader = new FileReader(filename);
		BufferedReader bReader = new BufferedReader(fReader);
		String lineOfCode = bReader.readLine();
		while (lineOfCode != null) {
			builder.append(lineOfCode);
			builder.append("\n");
            lineOfCode = bReader.readLine();
        }
		bReader.close();
		return builder.toString();
	}
	
}
