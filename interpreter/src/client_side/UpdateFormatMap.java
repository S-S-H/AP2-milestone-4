package client_side;

import java.util.HashMap;

import client_side.command.Command;

public class UpdateFormatMap {
	
	HashMap<Integer,String> update_format;
	
	public UpdateFormatMap()
	{//TODO: update this according to generic small.
		update_format=new HashMap<Integer,String>();
		update_format.put(0,"airspeed");
		update_format.put(1,"altimeter");
		update_format.put(2,"altimeter");
		update_format.put(3,"altimeter");
		update_format.put(4,"altimeter");
		update_format.put(5,"altimeter");
		update_format.put(6,"altimeter");
		update_format.put(7,"altimeter");
		update_format.put(8,"altimeter");
		update_format.put(9,"altimeter");
		update_format.put(10,"altimeter");
		update_format.put(11,"altimeter");
		update_format.put(12,"altimeter");
		update_format.put(13,"altimeter");
		update_format.put(14,"altimeter");
		update_format.put(15,"altimeter");
		update_format.put(16,"altimeter");
		update_format.put(17,"altimeter");
		update_format.put(18,"altimeter");
		update_format.put(19,"altimeter");
		update_format.put(20,"altimeter");
		update_format.put(21,"altimeter");
		update_format.put(22,"altimeter");
		update_format.put(23,"altimeter");
	}
	
	public String get(int key)
	{
		return update_format.get(key);
	}

}
