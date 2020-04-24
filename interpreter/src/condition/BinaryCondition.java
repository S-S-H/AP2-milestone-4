package condition;

public abstract class BinaryCondition implements Condition {
protected Condition c1,c2;

public BinaryCondition(Condition c1,Condition c2)
{
	this.c1=c1;
	this.c2=c2;
}
	
}
