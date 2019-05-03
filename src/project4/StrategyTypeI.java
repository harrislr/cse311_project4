package project4;

import java.util.Arrays;
import java.util.HashMap;

public class StrategyTypeI extends StrategyBase {

	@Override
	public boolean compareFiles(int f1, int f2) {
		return this.visitors.get(f1).getBlocks().equals(this.visitors.get(f2).getBlocks());
	}
}
