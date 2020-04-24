package client_side.command;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import client_side.expression.ExpressionConvertor;

public abstract class ConditionParser implements Command {

	protected String[] block;
	private String[] condition;


	// re-calculate the condition
	protected boolean state() {
		String operator = condition[1];
		String fixed_exp = ExpressionConvertor.infixToPostfix(Arrays.asList(condition[0]));
		double x = ExpressionConvertor.calculatePostfix(fixed_exp);
		fixed_exp = ExpressionConvertor.infixToPostfix(Arrays.asList(condition[2]));
		double y = ExpressionConvertor.calculatePostfix(fixed_exp);
		switch (operator) {
		case "==":
			return (x == y);
		case "!=":
			return (x != y);
		case "<":
			return (x < y);
		case "<=":
			return (x <= y);
		case ">":
			return (x > y);
		case ">=":
			return (x >= y);

		}
		return false;
	}

	// they're considered arguments because theyre relevant for the while to run
	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		int open_curly = 1;
		int close_curly = 0;
		int block_end = idx;
		List<String> container = new LinkedList<String>();
		// a way to detect our block boundaries
		while (close_curly < open_curly) {
			String token = tokens[block_end];
			if (token == "{")
				open_curly++;
			else if (token == "}")
				close_curly++;
			container.add(token);
			container = container.subList(1, container.size() - 2);// since we dont need the { } of the current block.
			container.toArray(this.block);
		}
		return block_end - idx;// tells the first parser to run to advance in the total block size.
	}

}
