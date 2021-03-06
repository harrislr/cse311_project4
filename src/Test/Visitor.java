package Test;
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
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WhileStatement;

public class Visitor extends ASTVisitor {
	private CompilationUnit cu;
	
	private String fileName;
	private ArrayList<String> blocks = new ArrayList<String>();
	private ArrayList<String> importDeclaration = new ArrayList<String>();
	private ArrayList<String> methodDeclaration = new ArrayList<String>();
	private ArrayList<String> methodUsage = new ArrayList<String>();
	private ArrayList<String> variableDeclaration = new ArrayList<String>();
	private ArrayList<String> variableUsage = new ArrayList<String>();
	
	public Visitor(CompilationUnit cu, String fileName) {
		this.cu = cu;
		this.fileName = fileName;
	}
	
	private Set names = new HashSet();
	 
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
		methodDeclaration.add("Line: " + (cu.getLineNumber(node.getStartPosition())) + ", Node: " + node.toString());
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
	
	public ArrayList getBlocks() {
		return this.blocks;
	}
	
	public ArrayList getMethodDeclaration() {
		return this.methodDeclaration;
	}
	
	public ArrayList getMethodUsage() {
		return this.methodUsage;
	}
	
	public ArrayList getVariableDeclaration() {
		return this.variableDeclaration;
	}
	
	public ArrayList getVariableUsage() {
		return this.variableUsage;
	}
	
}
