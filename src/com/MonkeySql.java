package com;

public class MonkeySql {
public static String monkey_Array [] = new String[10];
public static String Device_ID = "";
    public MonkeySql(){
    	for (int i = 0; i < monkey_Array.length; i++) {
    		monkey_Array[i] = ""; 
		}
    }

	public String[] getmonkey_array() {
		 return monkey_Array;
	}
	public static String getmonkey_array_Specify_the_value(int i) {
		 return monkey_Array[i];
	}
	public String[] setmonkey_array(String string,int i) {
		this.monkey_Array[i] = string;
		return monkey_Array;		
	}
	public String setDevice_ID(String Device_ID) {		
		return this.Device_ID = Device_ID;
		
	}
	public String getDevice_ID() {
		return Device_ID;
		
	}
	
}


