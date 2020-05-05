package test;

import java.util.*;
import Variable.Var;
import client_side.*;

public class MyInterpreter {

	// it should be here since various command use the hashmap.
	public static HashMap<String, Var> SymbolTable = new HashMap<String, Var>();
	public static double returnValue = 0;

	public static double interpret(String[] lines) {
		Lexer lexer = Lexer.getInstance();
		Parser parser = Parser.getInstance();
		String[] tokens = lexer.lexer(lines.toString());
		parser.parse(tokens);
		return returnValue;
	}
	
 
	
	

}