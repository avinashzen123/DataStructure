package com.avinash.tree;

import java.util.LinkedList;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/*
 * Given the root of a binary tree, return its maximum depth. 
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthBinaryTree {
	private static class TreeNode {
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

	/*
	 * Time Complexity : O(n)
	 */
	private static class RecursiveSolution {
		public static int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int leftDetpth = maxDepth(root.left) + 1;
			int rightDepth = maxDepth(root.right) + 1;
			return Math.max(leftDetpth, rightDepth);
		}
	}

	private static class IterativeSolution {
		public static int maxDepth(TreeNode root) {
			LinkedList<TreeNode> stack = new LinkedList<>();
			LinkedList<Integer> depths = new LinkedList<>();
			if (root == null)
				return 0;

			stack.add(root);
			depths.add(1);
			int depth = 0;
			int currDepth = 0;

			while (!stack.isEmpty()) {
				root = stack.pollLast();
				currDepth = depths.pollLast();
				if (root != null) {
					depth = Math.max(depth, currDepth);
					stack.add(root.left);
					stack.add(root.right);
					depths.add(currDepth + 1);
					depths.add(currDepth + 1);
				}
			}
			return depth;
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(2, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(RecursiveSolution.maxDepth(node));
		System.out.println(IterativeSolution.maxDepth(node));
	}
}
