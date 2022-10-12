package com.avinash.tree;

import java.util.ArrayList;
import java.util.List;

public class KPathSum {

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		private Node(int data) {
			this.data = data;
		}
	}
	
	private static Integer count = 0;

	public static void solve(Node root, int k, List<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.data);
		solve(root.left, k, path);
		solve(root.right, k, path);
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == k) {
				count ++;
				System.out.println(path);
			}
			
		}
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(1);
		solve(root, 5, new ArrayList<>());
		System.out.println(count);
	}
}
