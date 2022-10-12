package com.avinash.tree;

import java.util.Stack;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// https://www.youtube.com/watch?v=rKnD7rLT0lI
public class FlattenBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return this.val +  " -> " + left + " -> " + right;
		}
	}

	public static void flatten(TreeNode root) {
		// corner case
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);

			if (!stack.isEmpty()) {
				curr.right = stack.peek();
			}
			curr.left = null;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		System.out.println(root);
		flatten(root);
		System.out.println(root);
	}
}
