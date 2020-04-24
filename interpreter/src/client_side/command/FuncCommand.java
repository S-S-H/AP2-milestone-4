package client_side.command;

import java.util.ArrayList;
import java.util.List;

public class FuncCommand implements Command {
//still not sure what this command should be, is it a function as an expression or something??
	private ArrayList<Command> commands;

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doCommand(List<Object> args) {
		// TODO Auto-generated method stub
		
	}


}
