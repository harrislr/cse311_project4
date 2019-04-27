package project4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Visitor extends ASTVisitor {
	private CompilationUnit cu;
	
	public Visitor(CompilationUnit cu) {
		this.cu = cu;
	}
	
	private Set names = new HashSet();
	public static ArrayList declarations = new ArrayList<HashMap>();
	public static ArrayList usages = new ArrayList<HashMap>();
	 
	public boolean visit(VariableDeclarationFragment node) {
		SimpleName name = node.getName();
		this.names.add(name.getIdentifier());
		HashMap component = new HashMap<String, Integer>();
		component.put("line", cu.getLineNumber(name.getStartPosition()));
		component.put("name", name);
		declarations.add(component);
		return false;
			}
 
	public boolean visit(SimpleName node) {
		if (this.names.contains(node.getIdentifier())) {
			HashMap component = new HashMap<String, Integer>();
			component.put("line", cu.getLineNumber(node.getStartPosition()));
			component.put("name", node);
			usages.add(component);
		}
		return true;
	}
}
