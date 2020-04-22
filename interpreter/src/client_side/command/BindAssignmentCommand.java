package client_side.command;

import java.util.List;

import client_side.expression.BindVar;
import client_side.expression.Var;
import test.MyInterpreter;

public class BindAssignmentCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		emptyList.add(tokens[idx]);//add the name first
		return StringToArgumentParser.parse(tokens, idx+3, 1, emptyList, "String");
	}

	@Override
	public void doCommand(List<Object> args) {
		String name=args.get(0).toString();
		String path=args.get(1).toString();
		//meaning the variable has been created before by the var command being invoked.
		if( MyInterpreter.SymbolTable.containsKey(name))
			MyInterpreter.SymbolTable.put(name,new BindVar(name,path));

	}

}