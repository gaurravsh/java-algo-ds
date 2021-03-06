package com.gshar.dsalgo.combinatorics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	
	/** Given a collection of numbers, generate all possible subsets, i.e. power set.*/
	/*Contains bugs and needs to be fixed.*/
	public static List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        LinkedList<List<Integer>> list = new LinkedList<>();
        if(size<=0)
            return list;
        
        list.add(new LinkedList<Integer>());
		List<Integer> temp = new LinkedList<Integer>();
		temp.add(nums[0]);
        list.add(temp);
        
        System.out.println("list in starting : "+list.toString());
        for(int i=1;i<size;i++){
            LinkedList<List<Integer>> cloneList = new LinkedList<List<Integer>>(list);
            Iterator<List<Integer>> iter = cloneList.iterator();
            //System.out.printf("list hashcode : %d, clone hashcode = %d, iter hashcode  :%d%n",list.hashCode(),cloneList.hashCode(),iter.hashCode());
            System.out.println("l. list : "+list.toString());
			while(iter.hasNext()){
				//iter.add(nums[i]);
				List<Integer> curr=iter.next();
				System.out.println("current : "+curr.toString());
				curr.add(nums[i]);
				System.out.println("2. list : "+list.toString()+", cloneList : "+cloneList.toString());
			}
			System.out.println("3. list : "+list.toString());
			System.out.println("clone"+cloneList.toString());
			System.out.println("list before merge : "+list.toString());
			list.addAll(cloneList);
			System.out.println("list after merge : "+list.toString());
        }
        System.out.println("Result : "+list.toString());
        return list;
    }
}
