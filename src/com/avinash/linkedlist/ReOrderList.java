package com.avinash.linkedlist;

/*
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class ReOrderList {

	static class ListNode {
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
			if (this.next == null)
				return this.val + " ";
			else 
				return this.val + " " + this.next.toString();
		}
	}

	// 1 -> 2 -> 3 -> 4 -> 5
	public void reorderList(ListNode head) {
		ListNode slow = head, fast = head;
		while(slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode tmp = null, cur = slow, prev = null;
		while(cur != null) {
			tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		ListNode first = head, second = prev;
		while(second.next != null) {
			tmp = first.next;
			first.next = second;
			first = tmp;
			
			tmp = second.next;
			second.next = first;
			second = tmp;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ReOrderList list  = new ReOrderList();
		list.reorderList(node);
		System.out.println(node);
	}

}
