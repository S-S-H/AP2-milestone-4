package client_side.command;
import java.util.ArrayList;
import java.util.List;

public class ConditionParser implements Command {
	
protected ArrayList<Command> commands;

@Override
public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
	int i=idx;
	while(tokens[i]!="{") 
	{
	emptyList.add(tokens[i]);
	i++;
	}
	
}

@Override
public void doCommand(List<Object> args) {
	
	// TODO Auto-generated method stub
	
}


}

//change done 
