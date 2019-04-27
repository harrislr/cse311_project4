package project4;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Parser {

	public static void parse(String filename) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(filename.toCharArray());
		final CompilationUnit cu =	 (CompilationUnit)parser.createAST(null);
		cu.accept(new ASTVisitorTest(cu));
	}
	
}
