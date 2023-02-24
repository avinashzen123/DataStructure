package com.avinash.tree;

public class CountUniValueSubTree {
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

	int count = 0;
	/*
	 * Time complexity : O(n)
	 */
	private boolean isUniVal(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            count++;
            return true;
        }
        boolean isUniVal = true;
        if (node.left != null) {
            isUniVal = isUniVal(node.left) && node.left.val == node.val;
        }
        if (node.right != null) {
            isUniVal = isUniVal(node.right) && isUniVal && node.right.val == node.val;
        }
        if (!isUniVal) return false;
        count++;
        return true;
    }
	public int countUnivalSubtrees(TreeNode root) {
		count = 0;
		if (root != null)
			isUniVal(root);
		return count;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5, new TreeNode(1, new TreeNode(5), new TreeNode(5)),
				new TreeNode(5, null, new TreeNode(5)));
		System.out.println(new CountUniValueSubTree().countUnivalSubtrees(tree));
	}
}
