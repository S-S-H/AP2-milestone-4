package client_side.command;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import client_side.expression.DataServer;
import client_side.expression.MyDataServer;

public class DisconnectCommand implements Command {
	@Override
	public int getArguments(String[] tokens, int idx, List<Object> emptyList) {
		return 0;
	}
 
	@Override
	public void doCommand(List<Object> args) {
		Socket connection = ConnectCommand.connection;

		try {
			OutputStream out = connection.getOutputStream();
			PrintWriter UserOutput = new PrintWriter(out);
			UserOutput.write("bye");
			//client and simulator server are now closed.
		} catch (IOException e) {
			e.printStackTrace();
		}
        //is the simulator server closing before the client?
		//assume it isnt  
		Socket client_session = ConnectCommand.connection;
		try {
			client_session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//the simulator's server needs to send an ack too so we wont close before it
		//and result in timeout in the simulator's side. 
		
		DataServer ds = MyDataServer.getServer();
		ds.close();
		
	}

}
