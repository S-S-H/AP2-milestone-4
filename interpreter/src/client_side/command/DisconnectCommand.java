package client_side.command;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import client_side.expression.DataServer;
import client_side.expression.MyDataServer;

public class DisconnectCommand implements Command {
//TODO: realize if it has to work towards the other side as well.
	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return 0;
	}

	//responsibility to handle only our side of communication.
	@Override
	public void doCommand(List<Object> args) {
		DataServer ds = MyDataServer.getServer();
		ds.close();
		Socket client_session = ConnectCommand.connection;
		try {
			client_session.close();
		} catch (IOException e) {e.printStackTrace();}
	}

}
