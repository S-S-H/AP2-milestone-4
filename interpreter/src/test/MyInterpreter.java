package test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import client_side.*;
import client_side.command.Command;
import client_side.expression.Var;
public class MyInterpreter {

	//TODO: add the scopes class and support unglobal variables and add the function command.
	
	//it should be here since various command use the hashmap.
	//maybe i may move it to an abstract class of command to make the access easier.
	public static ConcurrentHashMap<String,Var> SymbolTable=new ConcurrentHashMap<String,Var>();

	
    
    
	
	public static int interpret(String[] lines){
	
		return 0;
	}
	
	
	
	//TODO: make sure to parse the expression.


		
	}
	
	
}
