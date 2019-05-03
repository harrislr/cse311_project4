package project4;
import java.io.IOException;



public class Main {
	public static void main(String[] args) throws IOException {
		StrategyTypeI strat = new StrategyTypeI();
		strat.retrieveFiles("files.txt");
		strat.parseAST();
		strat.getVisitors();
		strat.compareFiles();
	}
}
