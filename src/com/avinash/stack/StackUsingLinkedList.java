package com.avinash.stack;


class StackNode {
	private Integer data;
	private StackNode next;
	public StackNode (Integer data) {
		this.data = data;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
}


public class StackUsingLinkedList {

	private StackNode root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void push(Integer value) {
		StackNode node = new StackNode(value);
		if (this.root == null) {
			this.root = node;
		} else {
			node.setNext(this.root);
			this.root = node;
		}
	}
	
	public Integer peek() {
		if (this.root == null) {
			throw new IllegalStateException();
		}
		return this.root.getData();
	}
	
	public Integer pop() {
		if (this.root == null) {
			throw new IllegalStateException();
		}
		Integer data = this.root.getData();
		this.root = this.root.getNext();
		return data;
	}
	
	public static void main(String[] args) {
  
		StackUsingLinkedList sll = new StackUsingLinkedList();
  
        sll.push(10);
        sll.push(20);
        sll.push(30);
  
        System.out.println(sll.pop() + " popped from stack");
  
        System.out.println("Top element is " + sll.peek());
    }

}
