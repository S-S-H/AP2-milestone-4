package client_side.expression;

import test.MyInterpreter;

//TODO: check if i can take the name off since its a code-smell.

public abstract class Var implements Expression{
	String name;
	double value;
	
	//when a variable is created the default value is assigned.
	public Var(String name)
	{
		this.name=name;
		this.value=0;
	}
	
	
	public void set(Double value)
	{
		this.value=value;
	}
	

}
