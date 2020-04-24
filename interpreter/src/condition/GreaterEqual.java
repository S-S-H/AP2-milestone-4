package condition;

import client_side.expression.Expression;

public class GreaterEqual extends UnaryCondition {

	public GreaterEqual(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public boolean state() {
		return(e1.calculate()>=e2.calculate());
	}

}
