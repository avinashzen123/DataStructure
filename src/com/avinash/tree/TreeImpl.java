package com.avinash.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	Integer data;
	TreeNode left, right;
	int level;

	public TreeNode(Integer data) {
		this.data = data;
	}
	
	public TreeNode(Integer data, TreeNode left, TreeNode right) {
		this.data =data;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data + " ";
	}
}

public class TreeImpl {
	private TreeNode head;

	public void preOrder() {
		preOrder(this.head);
	}

	/*
	 * PreOrder using Stack
	 */
	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		// Note that we add currNode's right child to the stack first.
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.peek();
			stack.pop();
			if (currNode != null) {
				answer.add(currNode.data);
				stack.add(currNode.right);
				stack.add(currNode.left);
			}
		}

		return answer;
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
	
	public void inOrderIterative(TreeNode root) {
		if (root == null) return;
		List<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		while(!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.data);
				root = root.right;
			}
		}
		System.out.println("Inorder traveral " + list.toString());
	}

	public void postOrder() {
		postOrder(this.head);
	}

	// LRN (Left-right-node).
	private void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + "-");
	}

	public void postOrderTraversalIterative(TreeNode node) {
		if (node == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		stack.push(node);
		TreeNode prev = null;
		TreeNode current = null;
		while (!stack.isEmpty()) {
			current = stack.peek();
			/*
			 * go down the tree in search of a leaf an if so process it and pop stack
			 * otherwise move down
			 */
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null) {
					stack.push(current.left);
				} else if (current.right != null) {
					stack.push(current.right);
				} else {
					stack.pop();
					result.add(current.data);
				}
				/*
				 * go up the tree from left node, if the child is right push it onto stack
				 * otherwise process parent and pop stack
				 */
			} else if (current.left == prev) {
				if (current.right != null) {
					stack.push(current.right);
				} else {
					stack.pop();
					result.add(current.data);
				}
				/*
				 * go up the tree from right node and after coming back from right node process
				 * parent and pop stack
				 */
			} else {
				stack.pop();
				result.add(current.data);
			}
			prev = current;
		}
		System.out.println(result);
	}

	public void levelOrder() {
		System.out.println();
		TreeNode currentNode = this.head;
		currentNode.level = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(currentNode);
		while (!queue.isEmpty()) {
			TreeNode polledNode = queue.poll();
			System.out.print(polledNode.data + "->");
			if (polledNode.left != null)
				queue.add(polledNode.left);
			if (polledNode.right != null)
				queue.add(polledNode.right);
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
        tree.inOrderIterative(tree.head);
        System.out.println();
		tree.postOrder();
		System.out.println();
        tree.levelOrder();
        tree.totalLevels();
		tree.postOrderTraversalIterative(tree.head);
	}
}
