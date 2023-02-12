package com.avinash.linkedlist;

public class MergeSort {
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		@Override
		public String toString() {
			return this.val + " " + (this.next == null ? "" : this.next.toString());
		}
	}
	
	
	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode mid = getMid(head);
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(mid);
		return merge(left, right);
	}
	
	private static ListNode merge(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
	}
	
	private static ListNode getMid(ListNode head) {
		ListNode midPrev = null;
		while(head != null && head.next != null) {
			midPrev = midPrev == null ? head : midPrev.next;
			head = head.next.next;
		}
		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}
	
	
	
	public static void main(String[] args) {
		ListNode list = new ListNode(8, new ListNode(3, new ListNode(5, new ListNode(11, new ListNode(2, new ListNode(6))))));
		System.out.println(list);
		ListNode newList = mergeSort(list);
		System.out.println(newList);
	}
}
