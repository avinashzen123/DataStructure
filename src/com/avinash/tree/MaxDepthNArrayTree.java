package com.avinash.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.avinash.interview.Queue;

public class MaxDepthNArrayTree {

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
	
	
	private static class RecursiveSolution {
		public static int maxDepth(Node root) {
			if (root == null) {
				return 0;
			} else if (root.children.isEmpty()) {
				return 1;
			} else {
				List<Integer> heights = new LinkedList<>();
				for (Node item : root.children) {
					heights.add(maxDepth(item));
				}
				return Collections.max(heights) + 1;
			}
		}
	}
	
	private static class IterativeSolution {
	}
}
