package com.avinash.tree;

public class LowestCommonAncestorTwoNodes {
	
	private static class Node {
		private int data;
		private Node left;
		private Node right;
		private Node (int data) {
			this.data = data;
		}
	}
	
	public static Node leastCommonAncestor (Node root, int n1, int n2) {
		if (root == null) {
			return root;
		} else if (root.data == n1 || root.data == n2) {
			return root;
		}
		Node leftAns = leastCommonAncestor(root.left, n1, n2);
		Node rigtAns = leastCommonAncestor(root.right, n1, n2);
		if (leftAns != null && rigtAns != null) {
			return root;
		} else if (leftAns != null && rigtAns == null) {
			return leftAns;
		} else if (leftAns == null && rigtAns != null) {
			return rigtAns;
		} else {
			return null;
		}
	}

	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.left.right.left = new Node(12);
		root.left.right.right = new Node(9);
		root.right.left = new Node(22);
		root.right.right = new Node(27);
		root.right.right.left = new Node(29);
		System.out.println(leastCommonAncestor(root, 29, 9).data);
	}
}
