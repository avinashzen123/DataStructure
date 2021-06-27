package com.avinash.interview;

class Node1 {
	public Integer data;
	public Node1 next;

	public Node1(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + " " + next;
	}
}

public class Stack {
	private Node1 head;

	public void push(Integer data) {
		Node1 node = new Node1(data);
		if (head == null) {
			head  = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public Integer pop() {
		Integer data = head.data;
		head = head.next;
		return data;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
