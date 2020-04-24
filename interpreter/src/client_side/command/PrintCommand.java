package client_side.command;

import java.util.List;

public class PrintCommand implements Command {
//not done 
	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx, 1, emptyList, "String");
	}

	@Override
	public void doCommand(List<Object> args) {//TODO: make it support expressions and vars printing.
		String str = args.get(0).toString();
		System.out.println(str);
	}

}
