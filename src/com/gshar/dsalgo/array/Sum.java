package com.gshar.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class Sum {
	
	/** Link : https://leetcode.com/problems/two-sum/submissions/  */
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i])==null){
                map.put(nums[i],i);
            }
            else{
                int ind=map.get(target-nums[i]);
                int[] res = {ind,i};
                return res;
            }
        }
        return null;
    }
	
	
	/** Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/  */
	public static int[] twoSumSortedArray(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                int[] res={i+1,j+1};
                return res;
            }
            if(numbers[i]+numbers[j]<target){
                i++;
            }
            else{
                j--;
            }
                
        }
        return null;
    }
}
