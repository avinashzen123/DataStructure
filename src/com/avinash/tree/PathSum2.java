package com.avinash.tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
/*
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths 
 * where the sum of the node values in the path equals targetSum. Each path should be 
 * returned as a list of the node values, not node references. 
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 *  A leaf is a node with no children.
 */
public class PathSum2 {

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

	/*
	 * Time complexity O(n^2)
	 * 
	 * 2) where NNN are the number of nodes in a tree. In the worst case, we could
	 * have a complete binary tree and if that is the case, then there would be N/2
	 * leafs. For every leaf, we perform a potential O(N) operation of copying over
	 * the pathNodes nodes to a new list to be added to the final pathsList. Hence,
	 * the complexity in the worst case could be O(N2)
	 */
	public void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathList) {
		if (node == null)
			return;
		pathNodes.add(node.val);
		if (remainingSum == node.val && node.left == null && node.right == null) {
			pathList.add(new ArrayList<>(pathNodes));
		} else {
			this.recurseTree(node.left, remainingSum - node.val, pathNodes, pathList);
			this.recurseTree(node.right, remainingSum - node.val, pathNodes, pathList);
		}
		pathNodes.remove(pathNodes.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> pathsList = new ArrayList<>();
		List<Integer> pathNodes = new ArrayList<>();
		this.recurseTree(root, targetSum, pathNodes, pathsList);
		return pathsList;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
				new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));

		System.out.println(new PathSum2().pathSum(tree, 22));
	}

}
