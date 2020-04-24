package condition;

import client_side.expression.Expression;

public abstract class UnaryCondition implements Condition {
	protected Expression e1, e2;

	public UnaryCondition(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e2 = e2;

	}

}
