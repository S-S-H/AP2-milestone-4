package client_side.command;

import java.util.List;

public class IfCommand extends ConditionParser {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) 
	{
		return super.getArguments(tokens, idx, emptyList);
	}

	@Override
	public void doCommand(List<Object> args) 
	{
		if (super.calculateCondition() == true) 
		{
			commands.forEach(this.doCommand(args));
		}
		
	}

	
}
