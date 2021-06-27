package com.avinash.tree;


public class BinaryTree<T extends Comparable<T>> {
	Node<T> root;

	public void insert(T data) {
		if (root == null) {
			this.root = new Node<>(data);
		}
		insert(data, this.root);
	}

	private Node<T> insert(T data, Node<T> node) {
		if (node == null) {
			return new Node<T>(data);
		}
		if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(insert(data, node.getRightNode()));
			node.getRightNode().setParentNode(node);
		} else if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(insert(data, node.getLeftNode()));
			node.getLeftNode().setParentNode(node);
		}
		return node;
	}

	public void remove(T data) {
		if (root == null) {
			return;
		}
		remove(data, root);
	}

	private void remove(T data, Node<T> node) {
		if (node == null) {
			return;
		}
		Node<T> rightNode = node.getRightNode();
		Node<T> leftNode = node.getLeftNode();
		if (data.compareTo(node.getData()) > 0) {
			remove(data, rightNode);
		} else if (data.compareTo(node.getData()) < 0) {
			remove(data, leftNode);
		} else {
			Node<T> parent = node.getParentNode();
			if (leftNode == null && rightNode == null) {
				if (parent == null) {
					this.root = null;
				} else if (parent.compareTo(node) > 0) {
					parent.setRightNode(null);
				} else {
					parent.setLeftNode(null);
				}
			} else if (leftNode == null && rightNode != null) {
				if (parent.getLeftNode().equals(node)) {
					parent.setLeftNode(rightNode);
				} else {
					parent.setRightNode(leftNode);
				}
			} else if (leftNode != null && rightNode == null) {
				if (parent.getLeftNode().equals(node)) {
					parent.setLeftNode(leftNode);
				} else {
					parent.setRightNode(leftNode);
				}
			} else {
				Node<T> predecessor = node.getLeftNode();
				while (predecessor.getRightNode() != null) {
					predecessor = predecessor.getRightNode();
				}
				node.setData(predecessor.getData());
				if (predecessor.getLeftNode() != null) {
					if (predecessor.getParentNode().getLeftNode().equals(predecessor)) {
						predecessor.getParentNode().setLeftNode(predecessor.getLeftNode());
					} else if (predecessor.getParentNode().getRightNode().equals(predecessor)) {
						predecessor.getParentNode().setRightNode(predecessor.getLeftNode());
					}
				} else {
					if (predecessor.getParentNode().getLeftNode().equals(predecessor)) {
						predecessor.getParentNode().setLeftNode(null);
					} else if (predecessor.getParentNode().getRightNode().equals(predecessor)) {
						predecessor.getParentNode().setRightNode(null);
					}
				}
			}
		}

	}

	public static void main(String[] args) {

		BinaryTree<Integer> bst = new BinaryTree<>();

		bst.insert(12);
		bst.insert(5);
		bst.insert(78);
		bst.insert(56);
		bst.insert(34);
		bst.insert(41);
		bst.insert(8);
		bst.insert(3);
		bst.insert(12);
		BTreePrinter.printNode(bst.root);
		bst.remove(5);
		BTreePrinter.printNode(bst.root);

	}
}
