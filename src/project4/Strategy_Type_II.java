package project4;

public class Strategy_Type_II extends StrategyBase {

	@Override
	public void compareFiles() {
		System.out.println(getVisitors().toString());
		for(int i = 0; i<this.visitors.size(); i++) {
			for(int j = i+1; j<this.visitors.size(); j++) {
				if(this.visitors.get(i).getBlocks().equals(this.visitors.get(j).getBlocks())) {
					System.out.println(visitors.get(i).getFileName() + " & " + visitors.get(j).getFileName());
				}
			}
		}
		
	}

	@Override
	public void displayResults(int f1, int f2) {
		// TODO Auto-generated method stub
		
	}

}
