package com.avinash.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/boundary-of-binary-tree/description/
public class BoundaryOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public TreeNode(int x, TreeNode left, TreeNode right) {
			this.val = x;
			this.left = left;
			this.right = right;
		}
	}
	
	public static class Solution1  {
		private static boolean isLeaf(TreeNode node) {
			return node.left == null && node.right == null;
		}
		
		public static void addLeaves(List<Integer> res, TreeNode root) {
			if (isLeaf(root)) {
				res.add(root.val);
			} else {
				if (root.left != null) {
					addLeaves(res, root.left);
				} 
				if (root.right != null) {
					addLeaves(res, root.right);
				}
			}
		}
		
		public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
			ArrayList<Integer> res = new ArrayList<>();
			if (root == null) {
				return res;
			}
			if (!isLeaf(root)) {
				res.add(root.val);
			}
			TreeNode t = root.left;
			while(t != null) {
				if (!isLeaf(t)) {
					res.add(t.val);
				}
				if (t.left != null) {
					t = t.left;
				} else {
					t = t.right;
				}
			}
			addLeaves(res, root);
			Stack<Integer> s = new Stack<>();
			t = root.right;
			while(t != null) {
				if (!isLeaf(t)) {
					s.push(t.val);
				}
				if (t.right != null) {
					t = t.right;
				} else {
					t = t.left;
				}
			}
			while(!s.empty()) {
				res.add(s.pop());
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, null, 
				new TreeNode(2, new TreeNode(3), new TreeNode(4)));
		System.out.println(Solution1.boundaryOfBinaryTree(tree));
	}

}
