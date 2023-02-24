package com.avinash.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/
public class LowestCommonAncestorBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return " " + this.val;
		}
	}
	
	public static class RecursiveSolurion {
		private TreeNode ans;
		
		private boolean recurseTree(TreeNode currNode, TreeNode p, TreeNode q) {
	        if (currNode == null) return false;
	        int left = this.recurseTree(currNode.left, p, q) ? 1 : 0;
	        int right = this.recurseTree(currNode.right, p, q) ? 1 : 0;
	        int mid = (currNode.val == p.val || currNode.val == q.val) ? 1 : 0;
	        if (mid + left + right >= 2) {
	        	this.ans = currNode;
	        }
			return mid + left + right > 0;
	    }
		
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			this.recurseTree(root, p, q);
			return this.ans;
		}
	}
	
	public static class UsingParentPointer {
		 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			 Stack<TreeNode> stack = new Stack<>();
			 Map<Integer, TreeNode> parent = new HashMap<>();
			 parent.put(root.val, null);
			 stack.push(root);
			 while(!parent.containsKey(p.val) || !parent.containsKey(q.val)) {
				 TreeNode node = stack.pop();
				 if (node.left != null) {
					 parent.put(node.left.val, node);
					 stack.push(node.left);
				 }
				 if (node.right != null) {
					 parent.put(node.right.val, node);
					 stack.push(node.right);
				 }
			 }
			 Set<TreeNode> ancestor = new HashSet<>();
			 while(p  != null) {
				 ancestor.add(p);
				 p = parent.get(p.val);
			 }
			 while(!ancestor.contains(q)) {
				 q = parent.get(q.val);
			 }
			 return q;
		 }
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, 
				new TreeNode(5, 
						new TreeNode(6), 
						new TreeNode(2, 
								new TreeNode(7), 
								new TreeNode(4)
						)
					), 
				new TreeNode(1, 
						new TreeNode(0), 
						new TreeNode(8)
					)
			);
		
		RecursiveSolurion recursiveSolurion = new RecursiveSolurion();
		System.out.println(recursiveSolurion.lowestCommonAncestor(root, new TreeNode(5), 
				new TreeNode(1)));
		System.out.println(UsingParentPointer.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
	}
}
