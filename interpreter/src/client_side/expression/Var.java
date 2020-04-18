package client_side.expression;

public abstract class Var implements Expression{
	String name;
	double value;
	
	public Var(String name)
	{
		this.name=name;
		this.value=0;
	}
	
	public Var(String name, double value)
	{
		this.name=name;
		this.value=value;
	}
	
	public void set(Double value)
	{
		this.value=value;
	}
	

}
