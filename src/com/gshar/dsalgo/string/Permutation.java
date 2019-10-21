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
	
	private static String swap(int i, int j, String str){
		char[] c = str.toCharArray();
		char temp = c[i];
		c[i]=c[j];
		c[j]=temp;
		return String.valueOf(c);
	}
	
	/**Helper function for "permute" */
	private static void permuteFromInd(final int ind,String str){		
		if(str==null)
			return;
		
		int size=str.length();

		for(int i=ind;i<size;i++){
			String strnew = swap(ind,i,str);
			permuteFromInd(ind+1, strnew);
		}
		
		if(ind>=size)
			System.out.println(str);
	}
	
	/**Find all permutations of a string*/
	public static void permute(String str){
		permuteFromInd(0,str);
	}
}
