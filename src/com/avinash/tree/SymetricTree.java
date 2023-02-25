package com.avinash.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymetricTree {

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

	private static class RecursiveSolution {
		public static boolean isSymmetric(TreeNode root) {
			return isSymmetric(root, root);
		}
		
		private static boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null && right == null) return true;
			if (left == null || right == null) return false;
			return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}

	}
	
	private static class IterativeSolution {
		public static boolean isSymmetric(TreeNode root) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode left = queue.poll();
				TreeNode right = queue.poll();
				if (left == null && right == null) continue;
				if (left == null || right == null) return false;
				if (left.val != right.val) return false;
				queue.add(left.left);
	            queue.add(right.right);
	            queue.add(left.right);
	            queue.add(right.left);
			}
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(RecursiveSolution.isSymmetric(tree1));
		System.out.println(IterativeSolution.isSymmetric(tree1));
	}
}
