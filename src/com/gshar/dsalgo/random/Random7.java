package com.gshar.dsalgo.random;

import java.util.Random;

public class Random7 {
	
	/** Random number generator we already have, that generates random number from 1 to 5. */
	private static int rand5(){
		return new Random().nextInt(5)+1;
	}
	
	/**Using above function rand5(), generate random numbers from 1 to 7.*/
	public static int rand7(){		
		int row=0;
		int col=0;
		int val=0;
		do{
			row=rand5();
			col=rand5();
			
			val = (row-1)*5 + col;
		}while(val>=22);
		
		return val%7+1;
		
	}
}
