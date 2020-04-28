package client_side.command;

import java.util.Arrays;
import java.util.IllegalFormatConversionException;
import java.util.List;
import client_side.expression.ExpressionCalculate;


public class StringToArgumentParser {

//what about a case in which the last param is string and there are less parameters than expected
	// and it turns the next cmd lets say to a string?
     
	//TODO: ensure we enter the right amount and type of arguments 
	public static int parse(String[] tokens, int idx, int amount, List<Object> args, String... typeArguments) {
		for (int i = 0; i < amount; i++) {
			try {
				String type = typeArguments[i];
				if (type.equals("String"))
					args.add(tokens[idx]);
				else {
					
					double arg =ExpressionCalculate.invoke(Arrays.asList(tokens[i]));//go-to class and read doc.
					switch (type) {
					case "Double":
						args.add(arg);
						break;
					case "Integer":
						args.add((int) arg);
						break;
					}
				}

			}

			catch (IllegalFormatConversionException e) {
				e.printStackTrace();
			}

		}
		return amount;
	}

}
