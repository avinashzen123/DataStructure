package com.avinash.tree;

public class SumOfNodesInLongestPath {

	private static class Node {
		private int data;
		private Node left;
		private Node right;
		private Node (int data) {
			this.data = data;
		}
	}
	
	private static Integer maxSum = 0;
	private static Integer maxHeight = 0;
	
	public static int solve(Node root) {
		solve(root, 0, 0);
		return maxSum;
	}
	
	private static void solve(Node root, int curHeight, int curSum) {
		if (root == null) {
			if (curHeight > maxHeight) {
				maxHeight = curHeight;
				maxSum = curSum;
			} else if (curHeight == maxHeight ){
				maxSum = Math.max(curSum, maxSum);
			}
			return;
		}
		int sum  = curSum + root.data;
		solve(root.left, curHeight + 1, sum);
		solve(root.right, curHeight +1, sum);
	}
	
	public static void main(String[] args) {
//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.right = new Node(6);
//		root.left.left.left = new Node(7);
//		root.left.right.left = new Node(8);
//		root.left.right.right = new Node(9);
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(1);
		root.left.right.left = new Node(6);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		solve(root);
		System.out.println(maxSum);
	}
}
