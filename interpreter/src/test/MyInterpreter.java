package test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import Variable.Var;
import client_side.*;
import client_side.command.Command;
public class MyInterpreter {

	//TODO: add the scopes class and support unglobal variables and add the function command.
	
	//it should be here since various command use the hashmap.
	public static HashMap<String,Var> SymbolTable=new HashMap<String,Var>();

	public static int interpret(String[] lines){
	
		return 0;
	}
	
	
	
	//TODO: make sure to parse the expression.


	}