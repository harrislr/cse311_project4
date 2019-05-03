package project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StrategyTypeI extends StrategyBase {
	private ArrayList<String> result = new ArrayList<>();
	
	@Override
	public void compareFiles() {
//		System.out.println(getVisitors().toString());
		ArrayList<Visitor> temp = new ArrayList<>(this.visitors); 
		int group = 1;
		boolean flag= false;
		for(int i = 0; i<temp.size(); i++) {
			for(int j = i+1; j<temp.size(); j++) {
				flag = compareFile(i, j);
				if(flag) {
					temp.remove(temp.get(j));
				}
//					displayResults(i,j);
			}
			if(flag) {
				group++;
				flag = false;
			}
			
		}
	}
	private boolean compareFile(int f1, int f2) {
		String filename2 = this.visitors.get(f2).getFileName();
		if(this.visitors.get(f1).getBlocks().equals(this.visitors.get(f2).getBlocks())) {
			result.add(filename2);
			System.out.println(result.toString());
			return true;
		}
		return false;
	}
	
	@Override
	public void displayResults(int f1, int f2) {
		System.out.println(visitors.get(f1).getFileName() + " & " + visitors.get(f2).getFileName());
		
	}
	
}
