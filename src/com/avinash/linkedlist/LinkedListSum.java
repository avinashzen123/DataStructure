package com.avinash.linkedlist;

import lombok.ToString;

public class LinkedListSum {

	@ToString
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
		
		public LinkedList(int value, LinkedList next) {
			this.value = value;
			this.next = next;
		}
	}

	public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
		// Write your code here.
		LinkedList head = null;
		LinkedList curr = null;
		int carrOver = 0;
		while (linkedListOne != null || linkedListTwo != null) {
			int one = 0;
			int two = 0;
			if (linkedListOne != null) {
				one = linkedListOne.value;
				linkedListOne = linkedListOne.next;
			}
			if (linkedListTwo != null) {
				two = linkedListTwo.value;
				linkedListTwo = linkedListTwo.next;
			}
			int sum = one + two + carrOver;
			if (head == null) {
				head = new LinkedList(sum < 10 ? sum : sum % 10);
				curr = head;
			} else {
				curr.next = new LinkedList(sum < 10 ? sum : sum % 10);
				curr = curr.next;
			}
			carrOver = sum >= 10 ? sum / 10 : 0;
		}
		if (carrOver != 0) {
			curr.next = new LinkedList(carrOver);
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedList one = new LinkedList(2, new LinkedList(4, new LinkedList(7, new LinkedList(1))));
		LinkedList two = new LinkedList(9, new LinkedList(4, new LinkedList(5)));
		LinkedList sumOfLinkedLists = sumOfLinkedLists(one, two);
		System.out.println(sumOfLinkedLists);
		
		LinkedList one1 = new LinkedList(1, new LinkedList(1, new LinkedList(1)));
		LinkedList two1 = new LinkedList(9, new LinkedList(9, new LinkedList(9)));
		LinkedList sumOfLinkedLists2 = sumOfLinkedLists(one1, two1);
		System.out.println(sumOfLinkedLists2);
	}
}
