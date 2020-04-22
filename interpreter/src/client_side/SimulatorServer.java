package client_side;
import java.net.*;
import test.MyInterpreter;
import java.time.Duration;//used to calculate the pace.

import java.io.*; 
public class SimulatorServer {
	
public volatile boolean stop;
private UpdateFormatMap update_format;
//this is a singleton as well.
private static class SimulatorServerHolder
{
	public static final SimulatorServer server=new SimulatorServer();
}


private SimulatorServer()
{
this.stop=false;
this.update_format=new UpdateFormatMap();
}

//thats a singleton. get the instance of the server.
public static SimulatorServer getServer()
{
	return SimulatorServerHolder.server;
}

//should it be open(int port,int pace) (?)
//was (String address ,int port) in the arguments according to the sadna 
public void open(int port,int pace)
{
	
	Thread server_thread= new Thread(()->
	{
		try {
	ServerSocket server = new ServerSocket(port);
	server.setSoTimeout(3000);
	Socket aClient = server.accept(); 
	InputStream in= aClient.getInputStream();
	BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(in));
	while(!stop){
		
		//TODO:realize how to make the server read at required pace..
		//TODO: finish the logic of the server thread.
		//TODO: realize who invokes the stop and each disconnection.
		//dont forget to use the flush method here!
		String[] variables=inputFromClient.readLine().split(",");
		for(int i=0;i<variables.length;i++)
		{
		 String name=this.update_format.get(0);
		 if(MyInterpreter.SymbolTable.containsKey(name))//the update is relevant
		 {
			 MyInterpreter.SymbolTable.get(name).set(Double.parseDouble(variables[i]));		
		 }
		}
			
					
				
				Thread.sleep(pace);
					
	}
	aClient.close();
	server.close();
	
		}catch(IOException e) {e.printStackTrace();}
	
	});
  server_thread.start();
}


public void stop()
{
	this.stop=true;
}
//is this a method called from the running server thread to set the vars
//or is it a method called from send string?



public void setVariable(String name,double value)
{
	
}


public double getVariable(String var)
{
	
}




}
