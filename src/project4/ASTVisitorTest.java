package project4;
import java.io.BufferedReader;
import java.io.File;
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
//import org.eclipse.equinox.*;


public class ASTVisitorTest extends ASTVisitor {
	public ASTVisitorTest() {
		System.out.println("oh baby");
		parseOrSum("yes.txt");
	}
	
	public static void parseOrSum(String filename) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(filename.toCharArray());
//		 Map options = JavaCore.getOptions();
//		 JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
//		 parser.setCompilerOptions(options);
		final CompilationUnit cu =	 (CompilationUnit)parser.createAST(null);
		 cu.accept(new ASTVisitor() {
			 
				Set names = new HashSet();
	 
				public boolean visit(VariableDeclarationFragment node) {
					SimpleName name = node.getName();
					this.names.add(name.getIdentifier());
					System.out.println("Declaration of '" + name + "' at line"
							+ cu.getLineNumber(name.getStartPosition()));
					return false; // do not continue 
				}
	 
				public boolean visit(SimpleName node) {
					if (this.names.contains(node.getIdentifier())) {
						System.out.println("Usage of '" + node + "' at line "
								+ cu.getLineNumber(node.getStartPosition()));
					}
					return true;
				}
			});
	}
}
