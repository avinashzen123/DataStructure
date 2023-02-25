package com.avinash.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal1 {
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
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.val + " ";
		}
	}
	
	// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return List.of();
		List<List<Integer>> result = new ArrayList<>();
		boolean isEven = false;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while(!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> curList = new ArrayList<>();
			while(size -- > 0) {
				if (isEven) {
					TreeNode tmp = deque.pollLast();
					curList.add(tmp.val);
					if (tmp.right != null) deque.offerFirst(tmp.right);
					if (tmp.left != null) deque.offerFirst(tmp.left);
				} else {
					TreeNode tmp = deque.pollFirst();
					curList.add(tmp.val);
					if (tmp.left != null) deque.offerLast(tmp.left);
					if (tmp.right != null) deque.offerLast(tmp.right);
				}
			}
			isEven = !isEven;
			result.add(curList);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3, 
				new TreeNode(9), 
				new TreeNode(20, 
						new TreeNode(15), 
						new TreeNode(7)
						)
				);
		
		System.out.println(ZigZagTraversal1.zigzagLevelOrder(tree));

	}
}
