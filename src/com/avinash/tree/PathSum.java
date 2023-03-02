package com.avinash.tree;

import java.util.Stack;

// https://leetcode.com/problems/path-sum/
public class PathSum {

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

	private static class Recursive {
		public static boolean hasPathSum(TreeNode root, int targetSum) {
			if (root == null) return false;
			int remainingSum = targetSum - root.val;
			if (remainingSum == 0) return true;
			return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
		}
	}
	
	private static class Iterative {
		public static boolean hasPathSum(TreeNode root, int sum) {
			if (root == null) {
				return false;
			}
			Stack<TreeNode> nodeStack = new Stack<>();
			Stack<Integer> sumStack = new Stack<>();
			nodeStack.push(root);
			sumStack.push(sum - root.val);
			while(!nodeStack.isEmpty()) {
				root = nodeStack.pop();
				int curSum = sumStack.pop();
				if ( root.right == null && root.left == null && curSum == 0) {
					return true;
				}
				if (root.right != null) {
					nodeStack.push(root.right);
					sumStack.add(curSum - root.right.val);
				}
				if (root.left != null) {
					nodeStack.push(root.left);
					sumStack.add(curSum - root.left.val);
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5, 
				new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), 
				new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
			);
		System.out.println(Recursive.hasPathSum(tree, 22));
		System.out.println(Iterative.hasPathSum(tree, 22));
	}
}
