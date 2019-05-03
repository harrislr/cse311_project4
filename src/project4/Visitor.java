package project4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Visitor extends ASTVisitor {
	private CompilationUnit cu;
	
	private String fileName;
	private ArrayList<String> blocks = new ArrayList<String>();
	private ArrayList<String> importDeclaration = new ArrayList<String>();
	private ArrayList<String> methodSignatures = new ArrayList<String>();
	private ArrayList<String> methodUsage = new ArrayList<String>();
	private ArrayList<String> variableDeclaration = new ArrayList<String>();
	private ArrayList<String> variableUsage = new ArrayList<String>();
	
	public Visitor(CompilationUnit cu, String fileName) {
		this.cu = cu;
		this.fileName = fileName;
	}
	
	private Set<String> names = new HashSet<String>();
	 
	public boolean visit(Block node) {
		blocks.add(node.toString());
		return true;
	}
	
//	public boolean visit(CompilationUnit node) {
//		System.out.println(node.getPackage().getName());
//		return true;
//	}
	
	public boolean visit(VariableDeclarationFragment node) {
		SimpleName name = node.getName();
		this.names.add(name.getIdentifier());
		variableDeclaration.add("Line: " + (cu.getLineNumber(name.getStartPosition())) + ": " + name);
		return true;
	}
 
	public boolean visit(SimpleName node) {
		if (this.names.contains(node.getIdentifier())) {
			variableUsage.add("Line: " + (cu.getLineNumber(node.getStartPosition())) + ": " + node);
		}
		return true;
	}
	
	public boolean visit(ImportDeclaration node) {
		importDeclaration.add("Line: " + (cu.getLineNumber(node.getStartPosition())) + ", Node: " + node.toString());
		return true;
	}
	
//	public boolean visit(WhileStatement node) {
//		System.out.println(node.toString());
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(node.getStartPosition());
//		al.add(node.getLength());
//		return false;
//	}
	
	public boolean visit(MethodDeclaration node) {	
		methodSignatures.add((node.toString().split("\\{"))[0]);
		return true;
	}
	
	public boolean visit(MethodInvocation node) {
		methodUsage.add("Line: " + (cu.getLineNumber(node.getStartPosition())) + ", Node: " + node.toString());
		return true;
	}
	
	public boolean visit(ClassInstanceCreation node) {
//		System.out.println(node);
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(node.getStartPosition());
//		al.add(node.getLength());
		return true;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public ArrayList<String> getBlocks() {
		return this.blocks;
	}
	
	public ArrayList<String> getMethodSignature() {
		return this.methodSignatures;
	}
	
	public ArrayList<String> getMethodUsage() {
		return this.methodUsage;
	}
	
	public ArrayList<String> getVariableDeclaration() {
		return this.variableDeclaration;
	}
	
	public ArrayList<String> getVariableUsage() {
		return this.variableUsage;
	}
	@Override
	public String toString() {
		return this.fileName;
	}
}
