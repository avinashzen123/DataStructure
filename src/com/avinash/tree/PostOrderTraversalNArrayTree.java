package com.avinash.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
public class PostOrderTraversalNArrayTree {
	private static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<Integer> postOrder(Node node) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		stack.add(node);
		while(!stack.isEmpty()) {
			node = stack.pop();
			result.addFirst(node.val);
			for (Node item : node.children) {
				if (item != null) {
					stack.push(item);
				}
			}
		}
		return result;
	}
}
