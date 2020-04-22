package client_side.expression;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import client_side.command.ConnectCommand;

public class BindVar extends Var {
	String path;
	Var bounded;
//inherited data members:
	//string name
	//double value 
	//TODO: not only the server vars can be bounded. handle this!!!
	public BindVar(String name, String path) {
		super(name);
		this.path = path;
	}
	
	
	
	public void set(Double value) {
	    Socket connection=ConnectCommand.connection;
	    
	    try {
			OutputStream out= connection.getOutputStream();
			PrintWriter UserOutput=new PrintWriter(out);
		    UserOutput.write("set"+" "+path+" "+value);
			//after i send the value to the server it will make my local symbol-table change as well
		    //because of the server thread I'm running.
		} catch (IOException e) {e.printStackTrace();}	
	}
			

	@Override
	public double calculate() {
		return this.value;
	}

}
