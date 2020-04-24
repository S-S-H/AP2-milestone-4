package client_side.command;

import java.util.List;

import client_side.Parser;

public class LoopCommand extends ConditionParser {

	@Override
	public void doCommand(List<Object> args) {
		Parser parser=Parser.getInstance();
		while(state())
			parser.parse(block);				
	}

}
