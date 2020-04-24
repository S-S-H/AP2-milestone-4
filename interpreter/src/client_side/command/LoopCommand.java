package client_side.command;

import java.util.List;

public class LoopCommand extends ConditionParser {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) 
	{
		return super.getArguments(tokens, idx, emptyList);
	}

	@Override
	public void doCommand(List<Object> args) {
		if (super.calculateCondition() == true) 
		{
			commands.forEach(this.doCommand(args));
			//as I said, we maybe should save the intire block cause we need the other args for the other commands;
		}
		//it the same a ifcommand except we need to activate ourself again after, what we should do?
		
	}

	

}
