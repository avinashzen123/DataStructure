package com.avinash.tree;

// https://leetcode.com/problems/balanced-binary-tree/editorial/
public class BalancedBinaryTree {
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

	private static class TopDown_Recursive {
		private static int height(TreeNode node) {
			if (node == null)
				return -1;
			return 1 + Math.max(height(node.left), height(node.right));
		}

		// Time complexity : O(n log n)
		/*
		 * For a node p at depth d, height(p)will be called d times.
		 * We first need to obtain a bound on the height of a balanced 
		 * tree. Let f(h) represent the minimum number of nodes in a 
		 * balanced tree with height h. We have the relation
		 * 
		 * f(h)=f(h−1)+f(h−2)+1
		 * 
		 */
		public static boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left)
					&& isBalanced(root.right);
		}
	}
	
	private static final class TreeInfo {
		public final int height;
		public final boolean balanced;
		public TreeInfo(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
	}
	
	/*
	 * Time complexity : O(n)
	 */
	private static class BottomUpRecursive {
		private static TreeInfo isBalancedHelper(TreeNode node) {
			if (node == null) 
				return new TreeInfo(-1, true);
			
			TreeInfo left = isBalancedHelper(node.left);
			if (!left.balanced) {
				return new TreeInfo(-1, false);
			}
			TreeInfo right = isBalancedHelper(node.right);
			if (!right.balanced) {
				return new TreeInfo(-1, false);
			}
			if (Math.abs(left.height - right.height) < 2) {
				return new TreeInfo(Math.max(left.height, right.height) + 1, true);
			}
			return new TreeInfo(-1, false);
		}
		public static boolean isBalanced(TreeNode root) {
			return isBalancedHelper(root).balanced;
		}
	}

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(TopDown_Recursive.isBalanced(tree1));
		System.out.println(BottomUpRecursive.isBalanced(tree1));
	}
}
