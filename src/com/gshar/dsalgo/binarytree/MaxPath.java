package com.gshar.dsalgo.binarytree;

/** https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
 * 	https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * */


public class MaxPath {
	private int maxSum;

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int maxOf4(int a, int b, int c, int d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}

	private int util(TreeNode root) {
		if (root == null)
			return 0;

		int lsum = root.left == null ? 0 : Math.max(0, util(root.left));
		int rsum = root.right == null ? 0 : Math.max(0, util(root.right));

		int sum = maxOf4(root.val, root.val + lsum, root.val + rsum, root.val + lsum + rsum);

		if (maxSum < sum)
			maxSum = sum;
		return Math.max(lsum, rsum) + root.val;
	}

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		util(root);
		return maxSum;
	}
}
