package com.avinash.tree;


public class KthAncestor {

	private static class Node {
		private int data;
		private Node left;
		private Node right;
		private Node (int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		Node node = new KthAncestor(1).findKthAncestor(root, 7);
		if (node == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found ancestor " + node.data);
		}
	}
	
	private int k;
	
	public KthAncestor(int k) {
		this.k = k;
	}

	private Node findKthAncestor(Node root, int data) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			return root;
		}
		Node leftAns = findKthAncestor(root.left, data);
		Node rightAns = findKthAncestor(root.right, data);
		if (leftAns != null && rightAns == null) {
			k --;
			if ( k <= 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return leftAns;
		} else if (leftAns== null && rightAns != null) {
			k--;
			if (k <= 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return rightAns;
		} else {
			return null;
		}
	}
}
