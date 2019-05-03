package project4;
import java.io.IOException;
import java.util.ArrayList;

public abstract class StrategyBase {
	private String[] fileList;
	private ArrayList<String> files = new ArrayList<String>(); 
	protected ArrayList<Visitor> visitors = new ArrayList<Visitor>();
	
	public void retrieveFiles(String filename) throws IOException {
		String file = Parser.readFromFile("src/project4/" + filename);
		this.fileList = file.split("\\n+");
		for(int i = 0; i<this.fileList.length; i++) {
			this.files.add(Parser.readFromFile(this.fileList[i]));
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
