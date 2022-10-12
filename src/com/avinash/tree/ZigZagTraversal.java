package com.avinash.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://www.geeksforgeeks.org/zigzag-tree-traversal/
public class ZigZagTraversal {
	static class Node {
		public int data;
		public Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}

	static Node newNode(int data) {
		return new Node(data);
	}
	
	static List<Integer> zigZagTraversal(Node root) {
		Deque<Node> q = new LinkedList<>();
		List<Integer> v = new ArrayList<>();
		q.add(root);
		v.add(root.data);
		Node temp;
		int l = 1;
		while(q.size() > 0) {
			int n = q.size();
			for (int i = 0; i < n; i++) { 
				//Popping mechanism
				if (l % 2 == 0) {
					temp = q.pollLast();
				} else {
					temp = q.pollFirst();
				}
				//Pushing mechanism
				if (l % 2 != 0) {
					if (temp.right != null) {
						q.offerLast(temp);
						v.add(temp.right.data);
					}
					if (temp.left != null) {
						q.offerLast(temp.left);
						v.add(temp.left.data);
					}
				} else {
					if (temp.left != null) {
						q.offerFirst(temp.left);
						v.add(temp.left.data);
					} 
					if (temp.right != null){
						q.offerFirst(temp.right);
						v.add(temp.right.data);
					}
				}
			}
			l++;
		}
		return v;
	}
	
	public static void main(String[] args) {
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(7);
		root.left.right = newNode(6);
		root.right.left = newNode(5);
		root.right.right = newNode(4);
		System.out.println("ZigZap order traversal of binary tree");
		List<Integer> zigZagTraversal = zigZagTraversal(root);
		System.out.println(zigZagTraversal);
	}
}
