package com.avinash.linkedlist;

public class InsertionSort {
	static class Node {
		int val;
		Node next;
		public Node() {}
		public Node(int val) {
			this.val = val;
		}
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		@Override
		public String toString() {
			return this.val + " " + (this.next == null ? " " : this.next.toString());
		}
	}
	
	public static Node insertionSort(Node node) {
		Node dummy = new Node();
		Node current = node;
		while(current != null) {
			Node next = current.next;
			Node prev =  dummy;
			while(prev.next != null && prev.next.val <= current.val) {
				prev = prev.next;
			}
			current.next = prev.next;
			prev.next = current;
			current = next;
		}
		System.out.println(dummy.next);
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Node list = new Node(1, new Node(5, new Node(3, new Node(2, new Node(10)))));
		System.out.println(list);
		System.out.println("--------------");
		InsertionSort.insertionSort(list);
	}
}
