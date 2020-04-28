package client_side.command;

import java.util.List;
import test.MyInterpreter;

public class DefineVarCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx+1, 1, emptyList, "String");
	}

	@Override
	public void doCommand(List<Object> args) {
		String name = args.get(0).toString();
		MyInterpreter.SymbolTable.put(name, null);// we already know what the bind vars are? is is legitimate?
	}

}
