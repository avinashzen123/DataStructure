package com.avinash.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserailaizeBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		TreeNode(int x, TreeNode left, TreeNode right) {
			val = x;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return " " + this.val + (left != null ? left.toString() : " ") + (right != null ? right.toString() : " "); 
		}
	}

	public String serialize(TreeNode root) {
		return reserialize(root, "");
	}

	private String reserialize(TreeNode root, String string) {
		if (root == null) {
			string += "null,";
		} else {
			string += String.valueOf(root.val) + ",";
			string = reserialize(root.left, string);
			string = reserialize(root.right, string);
		}
		return string;
	}

	public TreeNode deserialize(String data) {
		String[] dataArray = data.split(",");
		List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
		return redeserialize(dataList);
	}

	private TreeNode redeserialize(List<String> dataList) {
		if (dataList.get(0).equals("null")) {
			dataList.remove(0);
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(dataList.get(0)));
		dataList.remove(0);
		node.left = redeserialize(dataList);
		node.right = redeserialize(dataList);
		return node;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
		System.out.println(tree);
		SerializeDeserailaizeBinaryTree binaryTree = new SerializeDeserailaizeBinaryTree();
		String serialize = binaryTree.serialize(tree);
		System.out.println(serialize);
		TreeNode deserialize = binaryTree.deserialize(serialize);
		System.out.println(deserialize);
	}
}
