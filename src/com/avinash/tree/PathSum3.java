package com.avinash.tree;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii">Leetcode</a>
 * 
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum. The
 * path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., travelling only from parent nodes to child nodes).
 */
public class PathSum3 {
	int count = 0;
	int k = 0;
	HashMap<Integer, Integer> map = new HashMap<>();
	
	public int pathSum(TreeNode root, int targetSum) {
		k = targetSum;
		preOrder(root, 0);
		return count;
	}

	private void preOrder(TreeNode node, int currSum) {
		if (node == null) {
			return;
		}
		currSum += node.data;
		// Here is the sum we are looking for
		if (currSum == k) {
			count++;
		}
		// Number of times the currSum - k has already occurred already
		// Determine the number of times a path with sum k has occurred upto current node;
		if (currSum - k != 0) {
			System.out.println("CurrSUm " + currSum + " Map " + map.toString());
		}
		count += map.getOrDefault(currSum - k, 0);
		
		//add Current sum into hashmap to use it during the child node processing
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		
		preOrder(node.left, currSum);
		preOrder(node.right, currSum);
		
		// Remove current sum from hashmap in order to use it during the parallel subtree
		map.put(currSum, map.get(currSum) - 1);
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(10, 
				new TreeNode(5, 
						new TreeNode(3, 
								new TreeNode(3), 
								new TreeNode(-2)), 
						new TreeNode(2, null, new TreeNode(1))
					), 
				new TreeNode(-3, null, new TreeNode(11)));
		System.out.println(new PathSum3().pathSum(tree, 8));
	}

}