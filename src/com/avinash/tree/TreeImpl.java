package com.avinash.tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    Integer data;
    TreeNode left, right;
    int level;

    public TreeNode(Integer data) {
        this.data = data;
    }
}
public class TreeImpl {
    private TreeNode head;

    public void preOrder() {
        preOrder(this.head);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "-");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(this.head);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "-");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.head);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "-");
    }
    
    public void levelOrder() {
    	System.out.println();
    	TreeNode currentNode = this.head;
    	currentNode.level = 0;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(currentNode);
    	while(!queue.isEmpty()) {
    		TreeNode polledNode = queue.poll();
    		System.out.print(polledNode.data + "->");
    		if (polledNode.left != null) queue.add(polledNode.left);
    		if (polledNode.right != null) queue.add(polledNode.right);
    	}
    }
    private Integer totalLevel = 0;
    public void totalLevels() {
    	totalLevels(head, 0);
    	System.out.println("\nTotal Levels = " + totalLevel);
    }
    
    public void totalLevels(TreeNode node, Integer level) {
    	totalLevel = level;
    	if (node.left != null) {
    		totalLevels(node.left, level + 1);
    	}
    	if (node.right != null) {
    		totalLevels(node.right, level + 1);
    	}
    }
    
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.head = new TreeNode(1);
        tree.head.left = new TreeNode(2);
        tree.head.right = new TreeNode(3);
        tree.head.left.left = new TreeNode(4);
        tree.head.left.right = new TreeNode(5);
        tree.head.right.left = new TreeNode(6);
        tree.head.right.right = new TreeNode(7);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        tree.levelOrder();
        tree.totalLevels();
    }
}
