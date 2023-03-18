package com.avinash.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubTrees {
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
			return " " + this.val;
		}
	}

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		findDuplicateSubtrees(root, new HashMap<>(), result);
		return result;
	}

	private static String findDuplicateSubtrees(TreeNode node, HashMap<String, Integer> tripletToId, 
			List<TreeNode> result) {
		if (node == null) return "";
		String representation = "(" + findDuplicateSubtrees(node.left, tripletToId, result) + ")"
				+ node.val + "(" + findDuplicateSubtrees(node.right, tripletToId, result) + ")";
		tripletToId.put(representation, tripletToId.getOrDefault(representation, 0) + 1);
		if (tripletToId.get(representation) == 2) {
			result.add(node);
		}
		return representation;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
		List<TreeNode> findDuplicateSubtrees = findDuplicateSubtrees(tree);
		System.out.println(findDuplicateSubtrees);
	}
}
