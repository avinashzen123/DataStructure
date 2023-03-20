package com.avinash.tree;

public class MaxPathSumBinaryTree {

	// https://leetcode.com/problems/binary-tree-maximum-path-sum/editorial/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int maxSum = 0;
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		int leftSum = Math.max(maxPathSum(root.left), 0);
		int rightSum = Math.max(maxPathSum(root.right), 0);
		maxSum = Math.max(maxSum, rightSum + leftSum + root.val);
		return Math.max(leftSum + root.val, rightSum + root.val);
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		MaxPathSumBinaryTree binaryTree = new MaxPathSumBinaryTree();
		binaryTree.maxPathSum(tree);
		System.out.println(binaryTree.maxSum);
		TreeNode tree1 = new TreeNode(-3);
		binaryTree = new MaxPathSumBinaryTree();
		binaryTree.maxPathSum(tree1);
		System.out.println(binaryTree.maxSum);
	}
}
