package com.avinash.tree;

import java.util.LinkedList;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/editorial/
public class MinDepthBinaryTree {

	public static class TreeNode {
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

	private static record Pair<T, R>(T key, R value) {
	};

	private static class Recursive {
		/*
		 * Time complexity : O(n)
		 */
		public static int minDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			if (root.left == null && root.right == null) {
				return 1;
			}
			int minDepth = Integer.MAX_VALUE;
			if (root.left != null) {
				minDepth = Math.min(minDepth(root.left), minDepth(root.right));
			}
			if (root.right != null) {
				minDepth = Math.min(minDepth(root.left), minDepth(root.right));
			}
			return minDepth + 1;
		}
	}

	/*
	 * Time complexity : O(n)
	 */
	private static class DFSIteration {
		public static int minDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
			stack.add(new Pair<>(root, 1));
			int minDepth = Integer.MAX_VALUE;

			while(!stack.isEmpty()) {
				Pair<TreeNode, Integer> current = stack.pollLast();
				root = current.key;
				int currentDepth = current.value;
				if (root.left == null && root.right == null) {
					minDepth = Math.min(minDepth, currentDepth);
				}
				if (root.left != null) {
					stack.add(new Pair<>(root.left, currentDepth + 1));
				}
				if (root.right != null) {
					stack.add(new Pair<>(root.right, currentDepth + 1));
				}
			}
			return minDepth;
		}
	}
	
	/*
	 * Time complexity : O(n)
	 */
	private static class BFSIteration {
		public static int minDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
			queue.add(new Pair<>(root, 1));
			int currentDepth = 0;
			while(!queue.isEmpty()) {
				Pair<TreeNode, Integer> current = queue.poll();
				root = current.key();
				currentDepth = current.value();
				if (root.left == null && root.right == null) {
					break;
				}
				if (root.left != null) {
					queue.add(new Pair<>(root.left, currentDepth + 1));
				}
				if (root.right != null) {
					queue.add(new Pair<>(root.right, currentDepth + 1));
				}
			}
			return currentDepth;
		}
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(Recursive.minDepth(tree));
		System.out.println(DFSIteration.minDepth(tree));
		System.out.println(BFSIteration.minDepth(tree));
	}
}
