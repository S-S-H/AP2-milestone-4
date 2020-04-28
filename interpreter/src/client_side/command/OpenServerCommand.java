package client_side.command;
import java.util.*;
import client_side.expression.*;
public class OpenServerCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx+1, 2, emptyList, "Integer","Integer");
	}

	@Override
	public void doCommand(List<Object> args) {
		int port=(int)args.get(0);
		int freq=(int)args.get(1);
		
		DataServer server=MyDataServer.getServer();
		String []paths=new String[3];
		paths[0]="simX";
		paths[1]="simY";
		paths[2]="simZ";
		server.open(port,freq,paths);
	}
	
}
