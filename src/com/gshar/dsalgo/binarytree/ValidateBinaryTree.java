package com.gshar.dsalgo.binarytree;

public class ValidateBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean validateSubtree(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;

		return root.val > minVal && root.val < maxVal && validateSubtree(root.left, minVal, root.val)
				&& validateSubtree(root.right, root.val, maxVal);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		return validateSubtree(root.left, Long.MIN_VALUE, root.val)
				&& validateSubtree(root.right, root.val, Long.MAX_VALUE);
	}
}
