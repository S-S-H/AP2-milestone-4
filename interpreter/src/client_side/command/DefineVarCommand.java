package client_side.command;

import java.util.List;

public class DefineVarCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
	return StringToArgumentParser.parse(tokens, idx,1,emptyList,"String");
	}

	@Override
	public void doCommand(List<Object> args) {
	System.out.println(args.get(0));
	}

}
