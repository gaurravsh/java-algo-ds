package com.gshar.dsalgo.string;

public class Subsequence {
	/**Given a string s and a string t, check if s is subsequence of t.
	 * https://leetcode.com/problems/is-subsequence/ */
	public static boolean isSubsequence(String s, String t) {
        if(s==null)
            return true;
        if(t==null)
            return false;
        int size1=s.length();
        int size2=t.length();
        if(size1>size2)
            return false;
        int i=0;
        int j=0;
        for(;i<size1 && j<size2;j++){
            if(s.charAt(i)==t.charAt(j))
                i++;
        }
        
        if(i==size1)
            return true;
        else
            return false;
    }
}
