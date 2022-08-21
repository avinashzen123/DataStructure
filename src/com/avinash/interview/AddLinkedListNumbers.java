package com.avinash.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class AddLinkedListNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryOver = 0;
		ListNode result = null;
		while (l1 != null || l2 != null) {
			int currentSum = 0;
			if (l1 != null && l2 != null) {
				currentSum = l1.val + l2.val + carryOver;
			} else if (l1 != null) {
				currentSum = l1.val + carryOver;
			} else if (l2 != null) {
				currentSum = l2.val + carryOver;
			}
			carryOver = currentSum / 10;
			if (result == null) {
				result = new ListNode(currentSum % 10);
			} else {
				ListNode nextNode = result;
				while (nextNode.next != null) {
					nextNode = nextNode.next;
				}
				nextNode.next = new ListNode(currentSum % 10);
			}
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carryOver != 0) {
			ListNode nextNode = result;
			while (nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = new ListNode(carryOver);
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		System.out.println(addTwoNumbers(l1, l2));
		
	}
}
