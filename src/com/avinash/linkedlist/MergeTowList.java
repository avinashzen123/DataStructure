package com.avinash.linkedlist;

public class MergeTowList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		@Override
		public String toString() {
			return " " + this.val + (this.next != null ? this.next.toString() : " ");
		}
	}

	static class Recursion {
		static ListNode mergeTwoList(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}
			if (l1.val < l2.val) {
				l1.next = mergeTwoList(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoList(l1, l2.next);
				return l2;
			}
		}
	}

	static class Iteration {
		static ListNode mergeTwoList(ListNode l1, ListNode l2) {
			ListNode prevHead = new ListNode(-1);
			ListNode prev = prevHead;
			while(l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					prev.next = l1;
					l1 = l1.next;
				} else {
					prev.next = l2;
					l2 = l2.next;
				}
				prev = prev.next;
			}
			prev.next = l1 == null ? l2 : l1;
			return prevHead.next;
		}
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode merge = Recursion.mergeTwoList(list1, list2);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(merge);
	}
}
