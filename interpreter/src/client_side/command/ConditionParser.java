package client_side.command;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import client_side.Lexer;
import client_side.Parser;
import client_side.expression.ExpressionConvertor;

public abstract class ConditionParser implements Command {

	protected ArrayList<Command> commands;
	private String[] parsed_condition;
//TODO: call super in subclasses!
	public ConditionParser() {
		this.commands = new ArrayList<Command>();
		this.parsed_condition=null;
		
	}

	//suits the arguments for the conditional command- the condition we will always need to re-calculate
	//and the COMMANDS contained within the block.
	//they're considered arguments because theyre relevant for the while to run 
	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		this.parseCondition(tokens, idx);
		int block_start=idx;
		int block_end=idx;
		List<String> container=new LinkedList<String>();
		
		while(tokens[block_end]!="}")
			{
			container.add(tokens[block_end]);
			block_end++;		
			}
		
		String[] block=container.toArray(new String[block_end-block_start]);
	    Parser parser=Parser.getInstance();
	    parser.parse(block);
	    
	    return block_start-block_end;
	}
	
//one-time condition-parsing.
	private void parseCondition(String[] tokens, int idx) {
		String str = "";
		while (!tokens[idx].contentEquals("{")) {
			str += tokens[idx];
			idx++;
		}
		// now the expression is represented by a string. lets break it to tokens using
		// our lexer.
		Lexer lex = Lexer.getInstance();
		String[] expression = lex.lexer(str);
		// since its going to die right after the scope ends..
		this.parsed_condition = expression.clone();

	}

//since the condition changes every time we got to re-calculate it
//its called in the sub-inheritors.
	protected boolean calculateCondition() {
		String fixed_exp = ExpressionConvertor.infixToPostfix(Arrays.asList(parsed_condition[0]));
		double arg1 = ExpressionConvertor.calculatePostfix(fixed_exp);
		fixed_exp = ExpressionConvertor.infixToPostfix(Arrays.asList(parsed_condition[2]));
		double arg2 = ExpressionConvertor.calculatePostfix(fixed_exp);
		String operator = parsed_condition[2];
		switch (operator) {
		case "==":
			return arg1 == arg2;

		case "!=":
			return arg1 != arg2;

		case "<":
			return arg1 < arg2;

		case ">":
			return arg1 > arg2;

		case "<=":
			return arg1 <= arg2;

		case ">=":
			return arg1 >= arg2;
			
		}
        return false;//or true..?
	}

}
