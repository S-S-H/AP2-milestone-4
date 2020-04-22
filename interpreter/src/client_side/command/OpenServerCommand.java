package client_side.command;
import java.util.*;

import client_side.SimulatorServer;
import client_side.expression.*;
public class OpenServerCommand implements Command {

	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return StringToArgumentParser.parse(tokens, idx, 2, emptyList, "Integer","Integer");
	}

	@Override
	public void doCommand(List<Object> args) {
		int port=(int)args.get(0);
		int pace=(int)args.get(1);
		SimulatorServer server=SimulatorServer.getServer();
		server.open(port,pace);
	}

	

	
}
