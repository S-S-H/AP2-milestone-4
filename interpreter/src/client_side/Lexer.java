package client_side;

import java.util.ArrayList;
import java.util.Scanner;

import client_side.expression.Utilities;

public class Lexer {
	// singleton
	private static class LexerHolder {
		public static final Lexer lexer = new Lexer();
	}

	private Lexer() {
	}

	public static Lexer getInstance() {
		return LexerHolder.lexer;
	}
	
   	//TODO: make another lexer method which supports files(?)
	// TODO: use a regex to break expression tokens properly.
	// breaks the code into tokens, line by line.
	public String[] lexer(String code) {	
		ArrayList<String> replacement=new ArrayList<String>();
		replacement.add("+");
		replacement.add("-");
		replacement.add("*");
		replacement.add("/");
		replacement.add("(");
		replacement.add(")");
		for (String delimiter:replacement)
		    code = code.replaceAll(" *\\" + delimiter + " *", " " + delimiter+ " ");
		
		
		ArrayList<String> tokens = new ArrayList<String>();
		Scanner s = new Scanner(code);
		
		while (s.hasNext())
			tokens.add(s.next());
		s.close();
		
		ArrayList<String> fixed_code=new ArrayList<String>();
		ArrayList<String> operators=new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
				
		for(int i=0;i<tokens.size()-1;i++)
		{
			
			String token=tokens.get(i);
			String token_next=tokens.get(i+1);
			boolean break1=token.equals("(")&&!operators.contains(token_next)&&!token_next.equals(token);
			boolean break2= token.equals(")")&&!operators.contains(token_next)&&!token_next.equals(token);
			boolean break3= (Utilities.isDouble(token)|Utilities.IsVar(token))&& (Utilities.isDouble(token_next)|Utilities.IsVar(token_next));		
			if(break1|break2|break3)
			{
			 fixed_code.add(token);
			 fixed_code.add(token);
			}	
			else
			{	
			  String value=fixed_code.get(i);		
			  fixed_code.set(i,value+token_next);
			}
			
		}
			
		String temp[] = fixed_code.toArray(new String[fixed_code.size()]);
		return temp;
	}
	
	

}
