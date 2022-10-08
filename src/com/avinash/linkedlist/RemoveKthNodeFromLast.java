package com.avinash.linkedlist;

import lombok.ToString;

public class RemoveKthNodeFromLast {
	@ToString
	private static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}

		public LinkedList(int value, LinkedList next) {
			this.value = value;
			this.next = next;
		}
	}

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		// Write your code here.
		LinkedList currNode = head;
		LinkedList temp = head;
		int numberOfNodes = 0;
		
		while (k > 0 && temp != null) {
			temp = temp.next;
			k--;
			numberOfNodes++;
		}
		System.out.println(temp);
	    while (temp != null && temp.next != null) {
	    	currNode = currNode.next;
	    	temp = temp.next;
	    	numberOfNodes++;
	    }
	    if (k == 0) {
	    	head.value = head.next.value;
	    	head.next = head.next.next;
	    } else {
	    	currNode.next = currNode.next.next;
	    }
//	    System.out.println(numberOfNodes);
	}
	
	public static void main(String[] args) {
		LinkedList head = new LinkedList(0, new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5, new LinkedList(6, new LinkedList(7, new LinkedList(8, new LinkedList(9))))))))));
		removeKthNodeFromEnd(head, 9);
		System.out.println(head);
	}

}
