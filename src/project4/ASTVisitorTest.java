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

public class ASTVisitorTest extends ASTVisitor {
	private CompilationUnit cu;
	
	public ASTVisitorTest(CompilationUnit cu) {
		this.cu = cu;
//		Parser.parse("");
	}
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
}
