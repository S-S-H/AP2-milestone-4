package client_side.command;

import java.util.List;

public class ReturnCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx, 1, emptyList, "Double");
	}

	//the calculated value is already in args[0]
	@Override
	public void doCommand(List<Object> args) {
	
	}

	/*private double retValue(double value) {
		return value;
	}*/

}
