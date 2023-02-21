package com.avinash.linkedlist;

import java.util.Stack;

public class LinkedListPallindrom {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.val + " "+ (this.next != null ? this.next.toString() : " ");
		}
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHaflStart = reverseList(firstHalfEnd.next);
		ListNode p1 = head;
		ListNode p2 = secondHaflStart;
		boolean result = true;
		while(result && p2 != null) {
			result = p1.val == p2.val;
			p1 = p1.next;
			p2 = p2.next;
		}
		firstHalfEnd.next = reverseList(secondHaflStart);
		return result;
	}
	
	
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode tmpNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmpNext;
		}
		return prev;
	}


	private static ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}


	public static void main(String[] args) {
//		ListNode list = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1))))));
		ListNode list = new ListNode(1, new ListNode(2));
		System.out.println(list);
		System.out.println(isPalindrome(list));
	}
	
}
