package Enums;

import java.util.Random;

public enum Value {
	ZERO,
	ONE,
	NONE;
	
	
	public static Value getRandom() {
		Random r = new Random();
		int randomizer = r.nextInt(10);
		if(randomizer < 5 ) {
			return Value.ONE;
		}else if(randomizer == 5){
			return Value.NONE;
		}else {
			return Value.ZERO;
		}
		
	}
	
}


