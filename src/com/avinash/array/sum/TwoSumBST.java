package com.avinash.array.sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TwoSumBST {
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

	static class UsingBSTTraversal {
		static boolean findTarget(TreeNode root, int k) {
			Set<Integer> set = new HashSet<>();
			return find(root, k, set);
		}

		static boolean find(TreeNode root, int k, Set<Integer> set) {
			if (root == null)
				return false;
			if (set.contains(k - root.val))
				return true;
			set.add(root.val);
			return find(root.left, k, set) || find(root.right, k, set);
		}
	}
	
	static class UsingBFSHashSet {
		static boolean findTarget(TreeNode root, int k) {
			Set<Integer> set = new HashSet<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node != null) {
					if (set.contains(k - node.val)) {
						return true;
					}
					set.add(node.val);
					queue.add(node.left);
					queue.add(node.right);
				} 
			}
			return false;
		}
	}
	
	static class UsingBSTInroderTraversal {
		static boolean findTarget(TreeNode root, int k) {
			List<Integer> list = new ArrayList<>();
			inorder(root, list);
			int lo = 0;
			int hi = list.size() - 1;
			while (lo < hi) {
				int sum = list.get(lo) + list.get(hi);
				if (sum == k) {
					return true;
				} else if (sum > k) {
					hi --;
				} else {
					lo ++;
				}
			}
			return false;
		}
		
		static void inorder(TreeNode node, List<Integer> list) {
			if (node == null) return;
			inorder(node.left, list);
			list.add(node.val);
			inorder(node.right, list);
		}
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7)));
		System.out.println(UsingBSTInroderTraversal.findTarget(tree, 9));
	}
}
