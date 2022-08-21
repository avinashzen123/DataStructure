package com.avinash.interview;

class BinaryTree {
	int value;
	BinaryTree left;
	BinaryTree right;

	BinaryTree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class BranchSum {
	
	public static Integer levelSum = 0;
	
	private Integer findNodeDepth(BinaryTree binaryTree, int level) {
		if (binaryTree == null) return 0;
		if (binaryTree.left == null && binaryTree.right == null) levelSum += level;
		if (binaryTree.left != null) return findNodeDepth(binaryTree.left, level + 1);
		if (binaryTree.right != null) return findNodeDepth(binaryTree.right, level + 1);
		return levelSum;
	}
	
	public static void main(String[] args) {
		BranchSum branchSum = new BranchSum();
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2); //1
		root.right = new BinaryTree(3); //1
		root.left.left = new BinaryTree(4);//2
		root.left.right = new BinaryTree(5);//2
		root.left.left.left = new BinaryTree(8); //4
		root.left.left.right = new BinaryTree(9);//4
		root.left.right.left = new BinaryTree(10); // 5
		
		System.out.println(branchSum.findNodeDepth(root, 0));
		System.out.println(BranchSum.levelSum);
		
		
	}
}
