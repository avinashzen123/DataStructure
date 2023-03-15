package com.avinash.linkedlist;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class ReverseLinkedList {

	@ToString
	@AllArgsConstructor
	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	public static LinkedList reverseLinkedList(LinkedList head) {
		// Write your code here.
		return reverseLinkedList(head, null);
	}

	private static LinkedList reverseLinkedList(LinkedList curNode, LinkedList prevNode) {
		if (curNode == null)
			return prevNode;
		LinkedList next = curNode.next;
		curNode.next = prevNode;
		return reverseLinkedList(next, curNode);
	}
	
	
	public static LinkedList reverseLinkedListRecr(LinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedList p = reverseLinkedListRecr(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
	
	public static LinkedList reverLinkedListIter(LinkedList head) {
		LinkedList prev = null;
		LinkedList cur = head;
		while(cur != null) {
			LinkedList nextTmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextTmp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LinkedList head = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4))));
		System.out.println(head);
		LinkedList reverseLinkedList = reverseLinkedList(head);
		System.out.println(reverseLinkedList);
	}
}
