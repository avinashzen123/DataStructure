package com.avinash.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/editorial/
public class SumRootToLeaf {
	static class Pair<U, V> {
		U first;
		V second;

		Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}

	static class TreeNode {
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
	}

	static class UsingIterativePreOrder {
		static int sumNumbers(TreeNode root) {
			Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
			int rootToLeaf = 0;
			stack.push(new Pair<>(root, 0));
			while (!stack.isEmpty()) {
				Pair<TreeNode, Integer> curPair = stack.pop();
				if (curPair.first != null) {
					int currSum = curPair.second * 10 + curPair.first.val;
					if (curPair.first.left == null && curPair.first.right == null) {
						rootToLeaf += currSum;
					} else {
						stack.push(new Pair<>(curPair.first.left, currSum));
						stack.push(new Pair<>(curPair.first.right, currSum));
					}
				}
			}
			return rootToLeaf;
		}
	}

	static class UsingRecursivePreOrder {
		int rootToLeaf = 0;

		public void preOrder(TreeNode root, int currNumber) {
			if (root != null) {
				currNumber = currNumber * 10 + root.val;
				if (root.left == null && root.right == null) {
					rootToLeaf += currNumber;
				}
				preOrder(root.left, currNumber);
				preOrder(root.right, currNumber);
			}
		}

		public int sumNumber(TreeNode root) {
			preOrder(root, 0);
			return rootToLeaf;
		}
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		System.out.println(UsingIterativePreOrder.sumNumbers(tree));
		System.out.println(new UsingRecursivePreOrder().sumNumber(tree));
	}
}
