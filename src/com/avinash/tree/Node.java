package com.avinash.tree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	private T data;
	private Node<T> leftNode;
	private Node<T> rightNode;
	private Node<T> parentNode;
	private int height;

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node<T> left) {
		this.leftNode = left;
	}

	public Node<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node<T> right) {
		this.rightNode = right;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.data.compareTo(o.data);
	}

	public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<?> other = (Node<?>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
