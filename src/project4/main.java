package project4;
import java.io.File;
import java.io.IOException;
import org.eclipse.jdt.core.dom.*;



public class Main {

	public static void main(String[] args) throws IOException {
		StrategyTypeI strat = new StrategyTypeI();
		strat.retrieveFiles("files.txt");
		strat.parseAST();
		strat.getVisitors();
		strat.compareFiles();
//		StrategyBase.step1("src/project4/files.txt");
//		String file = Parser.readFromFile("src/project4/Parser.java");
//		VisitorBlock vis = Parser.parse(file);
//		System.out.println(vis.getMethodDeclaration());
//		System.out.println(vis.getMethodUsage());
//		System.out.println(vis.getVariableDeclarations());
//		System.out.println(vis.getVariableUsage());
		
	}
}
