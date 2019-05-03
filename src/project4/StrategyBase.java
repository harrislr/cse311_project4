package project4;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jdt.core.dom.*;

public abstract class StrategyBase {

	final private String path = "src/project4/";
	private String[] fileList;
	private ArrayList<String> files = new ArrayList<String>(); 
	protected ArrayList<Visitor> visitors = new ArrayList<Visitor>();
	
	public void retrieveFiles(String filename) throws IOException {
		String file = Parser.readFromFile(this.path + filename);
		this.fileList = file.split("\\n+");
		for(int i = 0; i<this.fileList.length; i++) {
			this.files.add(Parser.readFromFile(this.path + this.fileList[i]));
		}
	}
	
	public void parseAST() {
		for(int i = 0; i<files.size(); i++) {
			visitors.add(Parser.parse(this.fileList[i], files.get(i)));
		}
	}

	public abstract void compareFiles();
	public abstract void displayResults();
	
	public ArrayList<String> getFiles() {
		return files;
	}
	public ArrayList<Visitor> getVisitors() {
		return visitors;
	}	
	
	
}
