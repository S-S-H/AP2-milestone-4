package client_side;

import java.util.ArrayList;
import java.util.List;
import client_side.command.Command;
import client_side.command.CommandsMap;


public class Parser {
//the parser needs to know the commands..	
	private CommandsMap mapper;// no need to make this static because we use the singleton design pattern!

	private static class ParserHolder {
		public static final Parser parser = new Parser();
	}

	private Parser() {
		mapper = CommandsMap.getInstance();
	}

	public static Parser getInstance() {
		return ParserHolder.parser;
	}

	public void parse(String[] tokens) {
		List<Object> args = new ArrayList<Object>();
		Command c;
		for (int i = 0; i < tokens.length;) {
			args.clear();// re-using an empty list for each command.
			c = mapper.get(tokens[i]);// check whether the specific token is a command or not.
			if (c != null) {
				i += c.getArguments(tokens, i, args);// one line of calling the stringtoarg parser in each cmd.
				c.doCommand(args);// the parser is the invoker
			}

		}

	}
}
