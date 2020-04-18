package client_side;
import java.util.ArrayList;
import java.util.List;

import client_side.CommandsMap;
import client_side.Lexer.LexerHolder;
import client_side.command.Command;

public class Parser {
//the parser needs to know the commands..	
private CommandsMap mapper;//no need to make this static because we use the singleton design pattern!
 
private static class ParserHolder{
	public static final Parser parser= new Parser();
}

private Parser()
{
	 mapper=new CommandsMap();
}

public Parser getInstance()
{
	return ParserHolder.parser;
}


	private void parse(String[] tokens)
	{
	List <Object> args=new ArrayList<Object>();
		for(int i=0;i<tokens.length;)
		{
			Command c=mapper.get(tokens[i]);// check whether the specific token is a command or not.
			if(c!=null)	
			{
					i+=c.getArguments(tokens,i,args);// one line of calling the stringtoarg parser in each cmd.	
					c.doCommand(args);//the parser is the invoker										
			}
					
			}

}
}
//added note 
