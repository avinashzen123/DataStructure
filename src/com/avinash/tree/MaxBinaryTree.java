package com.avinash.tree;

// https://leetcode.com/problems/maximum-binary-tree/description/
/**
 * You are given an integer array nums with no duplicates. A maximum binary tree
 * can be built recursively from nums using the following algorithm:
 * 
 * Create a root node whose value is the maximum value in nums. Recursively
 * build the left subtree on the subarray prefix to the left of the maximum
 * value. Recursively build the right subtree on the subarray suffix to the
 * right of the maximum value. Return the maximum binary tree built from nums.
 * 
 * 
 * Input: nums = [3,2,1,6,0,5]
 *
 * Output: [6,3,5,null,2,0,null,null,1]
 * 
 * Explanation: The recursive calls are as follow: - The largest value in
 * [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5]. - The
 * largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1]. -
 * Empty array, so no child. - The largest value in [2,1] is 2. Left prefix is
 * [] and right suffix is [1]. - Empty array, so no child. - Only one element,
 * so child is a node with value 1. - The largest value in [0,5] is 5. Left
 * prefix is [0] and right suffix is []. - Only one element, so child is a node
 * with value 0. - Empty array, so no child.
 * 
 */
public class MaxBinaryTree {
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

		@Override
		public String toString() {
			return " " + this.val + (this.left == null ? " " : this.left.toString())
					+ (this.right == null ? " " : this.right.toString());
		}
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
		if (left >= right)
			return null;
		int maxIdx = maxIndex(nums, left, right);
		TreeNode root = new TreeNode(nums[maxIdx]);
		root.left = constructMaximumBinaryTree(nums, left, maxIdx);
		root.right = constructMaximumBinaryTree(nums, maxIdx + 1, right);
		return root;
	}

	private int maxIndex(int[] nums, int left, int right) {
		int max = left;
		for (int i = left; i < right; i++) {
			if (nums[i] > nums[max]) {
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(6, new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1))),
				new TreeNode(5, new TreeNode(0), null));
		System.out.println(tree);
		MaxBinaryTree binaryTree = new MaxBinaryTree();
		TreeNode treeNode = binaryTree.constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		System.out.println(treeNode);

	}
}
