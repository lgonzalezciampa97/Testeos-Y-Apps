package com.loto.sorteo;

public class Tests {
	
	public static void main(String[] args) {
		
		Loader.loadNumbers();
		Loader.loadJacks();
		
		for (int i = 0 ; i <= 9 ; i++) {
			
			if(!Loader.lotoJacks.containsValue(i)) {
				System.out.println("Pos: "+ i + " = " + i);
			}
			else {
				System.out.println(i + ": Ya existe");
			}
		}
		
	}

}
