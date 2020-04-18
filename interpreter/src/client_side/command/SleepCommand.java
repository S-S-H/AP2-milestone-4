package client_side.command;

import java.util.List;

public class SleepCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx,1, emptyList, "Integer");
	}
//should it be like that?
	@Override
	public void doCommand(List<Object> args) {
		try
		{
			try {
				Thread.sleep((long)args.get(0));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(IllegalArgumentException e) {e.printStackTrace();}//sleep time is negative.
		
	}

}