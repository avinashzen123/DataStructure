package com.avinash.linkedlist;

import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class ListNode {
	Integer val;
	ListNode next;
	public void setNext(ListNode node) {
		this.next = node;
	}
}

public class LinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, null);
		head.setNext(new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
//		head.setNext(new ListNode(5, null));
		int left = 2;
//		int right = 4;
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		Stack<ListNode> stack = new Stack<>();
		Integer middleIndex = 0;
		Integer totalNode = 0;
		while(fastPointer!= null && fastPointer.next != null) {
			fastPointer = fastPointer.next;
			totalNode ++;
			if (fastPointer!=null) {
				fastPointer = fastPointer.next;
				totalNode++;
			}
			stack.push(slowPointer);
			slowPointer = slowPointer.next;
			middleIndex++;
		}
		System.out.println(middleIndex + " " + totalNode);
		if (totalNode <= 1) {
		} else if (totalNode == 2) {
			head.val = head.next.val + head.val;
			head.next.val = head.val - head.next.val;
			head.val = head.val - head.next.val;
		} else {
			while(middleIndex >= 0 && slowPointer.next != null) {
				if (middleIndex -1 == left) {
					ListNode temp1 = stack.pop();
					temp1.val = (temp1.val + slowPointer.next.val);
					slowPointer.next.val = (temp1.val - slowPointer.next.val);
					temp1.val = (temp1.val - slowPointer.next.val);
					break;
				}
				middleIndex--;
				slowPointer = slowPointer.next;
			}
		}
		
		
		System.out.println(middleIndex);
		System.out.println(slowPointer.val);
		System.out.println(head);
	}
}
