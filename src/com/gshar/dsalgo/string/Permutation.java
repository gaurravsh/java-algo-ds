package com.gshar.dsalgo.string;

public class Permutation {

	/** Given a String S consisting of lowercase English alphabets, 
	 * find out whether any permutation of this given String is a Palindrome*/
	public static boolean doesPalindromePermutationExist(String name){
		int[] count=new int[26];
		int size=name.length();
		int odds=0;
		
		for(int i=0; i<size; i++){
			int ind = (int)name.charAt(i)-(int)'a';
				count[ind] = (count[ind]+1)%2;
		}
		
		for(int i : count){
			if(i==1){
				odds++;
				if(odds>1)
					return false;
					
			}
		}
		return true;
	}
}
