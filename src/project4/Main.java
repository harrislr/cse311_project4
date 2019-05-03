package project4;
import java.io.IOException;



public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Strategy Type I----------------");
		StrategyTypeI strat = new StrategyTypeI();
		strat.retrieveFiles("files.txt");
		strat.parseAST();
		strat.getVisitors();
		strat.iteraterFiles();
		strat.displayMap();
		
		System.out.println("Strategy Type II---------------");
		Strategy_Type_II strat2 = new Strategy_Type_II();
		strat2.retrieveFiles("files.txt");
		strat2.parseAST();
		strat2.getVisitors();
		strat2.iteraterFiles();
		strat2.displayMap();
		
//		System.out.println("Strategy Type III----------------");
//		StrategyTypeIII strat3 = new StrategyTypeIII();
//		strat3.retrieveFiles("files.txt");
//		strat3.parseAST();
//		strat3.getVisitors();
//		strat3.iteraterFiles();
//		strat3.displayMap();
//		
//		System.out.println("Strategy Type IIII---------------");
//		Strategy_Type_IIII strat4 = new Strategy_Type_IIII();
//		strat4.retrieveFiles("files.txt");
//		strat4.parseAST();
//		strat4.getVisitors();
//		strat4.iteraterFiles();
//		strat4.displayMap();
		
	}
}
