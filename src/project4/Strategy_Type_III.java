package project4;

import java.util.Scanner;

public class Strategy_Type_III extends StrategyBase {

	@Override
	public void compareFiles() {
		
		int total = this.visitors.size(); //total
		int matches = 0; //track what was the same
		
		for(int i = 0; i<this.visitors.size(); i++) {
			for(int j = i+1; j<this.visitors.size(); j++) {
				if(this.visitors.get(i).getBlocks().equals(this.visitors.get(j).getBlocks()))
				{
					matches = matches + 1; //increment counter
				}
			}
		}
		
		double percentage = matches / total; //compare what was the same to total
		// compare total to user defined threshold
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter what percentage for similarity threshold");
		double threshold = in.nextDouble();
		
		if(percentage >= threshold)
		{
			System.out.println("This is a clone");
		}
		
	}

	@Override
	public void displayResults(int f1, int f2) {
		// TODO Auto-generated method stub
		
	}

}
