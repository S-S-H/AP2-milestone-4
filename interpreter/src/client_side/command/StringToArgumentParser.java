package client_side.command;

import java.util.IllegalFormatConversionException;
import java.util.List;

public class StringToArgumentParser {
	
private StringToArgumentParser() {
	
}//do we really need to create an instance of this for each one?
public static int parse(String[]tokens,int idx,int amount,List<Object>args,String ...typeArguments)
{
	for(int i=0;i<amount;i++)
	{
		try {
		switch(typeArguments[i])
		{
		
		case "Double": args.add(Double.parseDouble(tokens[idx]));
			break;
			
		case "Integer": args.add(Integer.parseInt(tokens[idx]));
			break;
			
		default: args.add(tokens[idx]);
			
		}
		} catch(IllegalFormatConversionException e) {e.printStackTrace();} 
		
		
	}
	return amount;
}

}
