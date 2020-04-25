package client_side.command;

import java.util.Arrays;
import java.util.List;

import client_side.expression.ExpressionCalculate;
import client_side.expression.ExpressionConvertor;

public class PrintCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx, 1, emptyList, "String");
	}

	//TODO:make sure concatenate isn't an option.
	@Override
	public void doCommand(List<Object> args) {
		String str = args.get(0).toString();
		if(str.charAt(0)!='"')//meaning, its a variable
		{		
			str= Double.toString((ExpressionCalculate.invoke(Arrays.asList(str))));
		}
		else
		{
			str=str.substring(0,str.length()-2);
		}
		System.out.println(str);
	}

}
