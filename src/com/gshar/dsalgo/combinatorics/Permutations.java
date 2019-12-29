package com.gshar.dsalgo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generates permutation of a given input array
 **/

public class Permutations {
	private static int count = 0;

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	private static void swapList(ArrayList<Integer> list, int i, int j) {
		int vi = list.get(i);
		int vj = list.get(j);
		list.set(i, vj);
		list.set(j, vi);
	}

	public static void printPermutations(int[] input) {
		for (int i = 0; i < input.length; i++) {
			swap(input, 0, i);
			permuteUtil(input, 1);
			swap(input, i, 0);
		}

		System.out.println("Total permutations : " + count);
	}

	public static ArrayList<ArrayList<Integer>> generatePermutationList(ArrayList<Integer> input) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int listSize = input.size();
		for (int i = 0; i < listSize; i++) {
			swapList(input, 0, i);
			permuteListUtil(list, input, 1);
			swapList(input, i, 0);
		}
		return list;
	}

	@SuppressWarnings({ "unchecked"})
	private static void permuteListUtil(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> input,
			int init) {
		int listSize = input.size();
		if (init >= listSize) {
			list.add( (ArrayList<Integer>) input.clone());
			return;
		}
		for (int i = init; i < listSize; i++) {
			swapList(input, init, i);
			permuteListUtil(list, input, init+1);
			swapList(input, i, init);
		}
	}

	private static void permuteUtil(int[] input, int init) {
		if (init >= input.length) {
			System.out.println(Arrays.toString(input));
			count++;
			return;
		}

		for (int i = init; i < input.length; i++) {
			swap(input, init, i);
			permuteUtil(input, init + 1);
			swap(input, i, init);
		}
	}
}
