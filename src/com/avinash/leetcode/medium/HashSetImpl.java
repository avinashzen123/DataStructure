package com.avinash.leetcode.medium;

import java.util.LinkedList;

/**
 * Time complexity : O(N/K) Space complexity : O(K + M)
 */
class HashSetLinkedListIml {
	private static class Bucket {
		private LinkedList<Integer> container;

		public Bucket() {
			this.container = new LinkedList<>();
		}

		public void insert(Integer key) {
			int index = this.container.indexOf(key);
			if (index == -1) {
				this.container.addFirst(key);
			}
		}

		public void delete(Integer key) {
			this.container.remove(key);
		}

		public boolean exist(Integer key) {
			int index = this.container.indexOf(key);
			return index != -1;
		}
	}

	public Bucket[] bucketArray;
	private int keyRange;// https://leetcode.com/problems/design-hashset/editorial/

	public HashSetLinkedListIml() {
		this.keyRange = 769;
		this.bucketArray = new Bucket[this.keyRange];
		for (int i = 0; i < this.keyRange; i++) {
			this.bucketArray[i] = new Bucket();
		}
	}

	protected int hash(int key) {
		return key % this.keyRange;
	}

	public void add(int key) {
		int bucketIndex = this.hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}

	public void remove(int key) {
		int bucketIndex = this.hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}

	public boolean contains(int key) {
		int bucketIndex = this.hash(key);
		return this.bucketArray[bucketIndex].exist(key);
	}
}

class HashSetTreeImpl {
	private static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	private static class BSTree {
		TreeNode root = null;

		public TreeNode searchBST(TreeNode root, int val) {
			if (root == null || val == root.val) {
				return root;
			}
			return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
		}

		public TreeNode insertIntoBST(TreeNode root, int val) {
			if (root == null) {
				return new TreeNode(val);
			}
			if (val > root.val) {
				root.right = insertIntoBST(root.right, val);
			} else if (val < root.val) {
				root.left = insertIntoBST(root.left, val);
			}
			return root;
		}

		public int successor(TreeNode root) {
			root = root.right;
			while (root.left != null) {
				root = root.left;
			}
			return root.val;
		}

		public int predecessor(TreeNode root) {
			root = root.left;
			while (root.right != null) {
				root = root.right;
			}
			return root.val;
		}

		public TreeNode deleteNode(TreeNode root, int key) {
			if (root == null) {
				return null;
			}
			if (key > root.val) {
				root.right = deleteNode(root.right, key);
			} else if (key < root.val) {
				root.left = deleteNode(root.left, key);
			} else {
				if (root.left == null && root.right == null) {
					root = null;
				} else if (root.right == null) {
					root.val = successor(root);
					root.right = deleteNode(root.right, root.val);
				} else {
					root.val = predecessor(root);
					root.left = deleteNode(root.left, root.val);
				}
			}
			return root;
		}
	}

	private static class Bucket {
		private BSTree tree;

		public Bucket() {
			this.tree = new BSTree();
		}

		public void insert(Integer key) {
			this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
		}

		public void delete(Integer key) {
			this.tree.root = this.tree.deleteNode(this.tree.root, key);
		}

		public boolean exists(Integer key) {
			TreeNode node = this.tree.searchBST(this.tree.root, key);
			return (node != null);
		}
	}

	private Bucket[] bucketArray;
	private int keyRange;

	HashSetTreeImpl() {
		this.keyRange = 769;
		this.bucketArray = new Bucket[this.keyRange];
		for (int i = 0; i < this.keyRange; i++) {
			this.bucketArray[i] = new Bucket();
		}
	}

	protected int hash(int key) {
		return key % this.keyRange;
	}

	public void add(int key) {
		int bucketIndex = this.hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}

	public void remove(int key) {
		int bucketIndex = this.hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucketIndex = this.hash(key);
		return this.bucketArray[bucketIndex].exists(key);
	}
}

public class HashSetImpl {
	public static void main(String[] args) {
		HashSetLinkedListIml linkedListSet = new HashSetLinkedListIml();
		linkedListSet.add(10);
		linkedListSet.add(10);
		linkedListSet.add(11);
		linkedListSet.remove(10);
		System.out.println(linkedListSet.contains(11));
	}
}
