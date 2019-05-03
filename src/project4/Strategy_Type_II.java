package project4;

public class Strategy_Type_II extends StrategyBase {

	@Override
	public boolean compareFiles(int f1, int f2) {
		return this.visitors.get(f1).getMethodSignature().equals(this.visitors.get(f2).getMethodSignature());
	}

}
