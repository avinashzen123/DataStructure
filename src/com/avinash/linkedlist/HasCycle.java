package com.avinash.linkedlist;

public class HasCycle {
	private class Node {
		Integer data;
		Node next;
	}
	
	public boolean hasCycle(Node node) {
		Node slow = node;
		Node fast = node;
		while(slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
