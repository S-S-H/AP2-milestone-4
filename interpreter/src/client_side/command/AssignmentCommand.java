package client_side.command;

import java.util.List;
import Variable.RegularVar;
import test.MyInterpreter;

public class AssignmentCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		emptyList.add(tokens[idx]);//add the name first
		return StringToArgumentParser.parse(tokens, idx+2, 1, emptyList, "Double");
	}

	@Override
	public void doCommand(List<Object> args) {
		String name=args.get(0).toString();
		double value=(double)args.get(1);
		//value assigned right after creation- regularVar.		
		if(MyInterpreter.SymbolTable.get(name)==null)
		{
			MyInterpreter.SymbolTable.put(name,new RegularVar(value));
		}//already initialized
	    MyInterpreter.SymbolTable.get(name).set(value);;
	}

}
