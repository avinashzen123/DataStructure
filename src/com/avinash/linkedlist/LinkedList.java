package com.avinash.linkedlist;

import lombok.AllArgsConstructor;

public class LinkedList {
	@AllArgsConstructor
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode reverseLinkedListIter(ListNode head) {
		ListNode currNode  = head;
		ListNode prevNode = null;
		while(currNode != null) {
			ListNode temp = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = temp;
		}
		return prevNode;
	}
	
	public static void traverse(ListNode root) {
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		traverse(head);
		head = reverseLinkedListIter(head);
		traverse(head);
	}
}
