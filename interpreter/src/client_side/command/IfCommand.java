package client_side.command;

import java.util.List;
import client_side.Parser;

public class IfCommand extends ConditionParser {

	@Override
	public void doCommand(List<Object> args) {
		Parser parser=Parser.getInstance();
		if(state()) 
			parser.parse(block);	
	}

}
