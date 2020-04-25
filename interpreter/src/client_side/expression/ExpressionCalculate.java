package client_side.expression;

import java.util.List;
//I saw those two lines repeatedly in the code so I decided to make it neater.
public class ExpressionCalculate {
	public static double invoke(List<String> expression)
	{
	String fixed_exp = ExpressionConvertor.infixToPostfix(expression);
	return ExpressionConvertor.calculatePostfix(fixed_exp);
	}
}
