package client_side.expression;

import test.MyInterpreter;

public class RegularVar extends Var {

	public RegularVar(String name, double value) {
		super(name);
		this.value = value;
	}

	@Override
	public double calculate() {
		return this.value;
	}
	
	public void set(double value) {
		super.set(value);
		//We dont really need the following line!
		MyInterpreter.SymbolTable.put(name,this);
	}

}
