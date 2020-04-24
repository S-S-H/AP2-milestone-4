package condition;

public class And extends BinaryCondition {

	public And(Condition c1, Condition c2) {
		super(c1, c2);
	}

	@Override
	public boolean state() {
		return (c1.state() && c2.state());
	}

}
