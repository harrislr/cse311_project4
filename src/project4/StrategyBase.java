package project4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class StrategyBase {
	private String[] fileList;
	private ArrayList<String> files = new ArrayList<String>();
	protected ArrayList<Visitor> visitors = new ArrayList<Visitor>();
	private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	public void retrieveFiles(String filename) throws IOException {
		String file = Parser.readFromFile("src/project4/" + filename);
		this.fileList = file.split("\\n+");
		for (int i = 0; i < this.fileList.length; i++) {
			this.files.add(Parser.readFromFile(this.fileList[i]));
		}
	}

	public void parseAST() {
		for (int i = 0; i < files.size(); i++) {
			visitors.add(Parser.parse(this.fileList[i], files.get(i)));
		}
	}

	public void iteraterFiles() {
//		System.out.println(getVisitors().toString());
		int group = 1;
		ArrayList<Visitor> temp = new ArrayList<>(this.visitors);
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < temp.size(); i++) {
			result = new ArrayList<>();
			for (int j = i + 1; j < temp.size(); j++) {
				if (compareFiles(i, j)) {
//					System.out.println(this.visitors.get(j).getFileName());
					result.add(this.visitors.get(j).getFileName());
					temp.remove(this.visitors.get(j));
				}
			}
		}
//		System.out.println("result" + result.toString());
		if (!result.isEmpty()) {
			map.put(group++, result);
		}
	}

	public abstract boolean compareFiles(int f1, int f2);

	public ArrayList<String> getFiles() {
		return files;
	}

	public ArrayList<Visitor> getVisitors() {
		return visitors;
	}
	
	public void displayMap() {
		map.forEach((key,value) -> System.out.println("Group " + key + ":\n" + value.toString()));
	}

}
