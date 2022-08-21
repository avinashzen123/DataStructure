package com.avinash.interview;

import lombok.Data;
import lombok.ToString;


public class MergeKSortedList {
	@Data
	static class ListNode {
		private int val;
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
			return " " + val + " " + next; 
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		ListNode result = lists[0];
		for (int i = 1; i < lists.length; i++) {
			result = mergeTwoList(result, lists[i]);
		}
		return result;
	}
	
	public ListNode mergeTwoList(ListNode list1, ListNode list2) {
		ListNode list = new ListNode(0);
		ListNode currentNode = list;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				currentNode.next = new ListNode(list1.val);
				list1 = list1.next;
			} else if (list1.val > list2.val) {
				currentNode.next = new ListNode(list2.val);
				list2 = list2.next;
			} else {
				currentNode.next = new ListNode(list1.val);
				currentNode = currentNode.next;
				currentNode.next = new ListNode(list2.val);
				list2 = list2.next;
				list1 = list1.next;
			}
			currentNode = currentNode.next;
		}
		while (list1 != null) {
			currentNode.next = new ListNode(list1.val);
			list1 = list1.next;
			currentNode = currentNode.next;
		}
		while (list2 != null) {
			currentNode.next = new ListNode(list2.val);
			list2 = list2.next;
			currentNode = currentNode.next;
		}
		return list.next;
	}
	
	public static void main(String[] args) {
		//[[1,2,3],[4,5,6,7]]

		ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
		ListNode listNode1 = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))));
		ListNode mergeKLists = new MergeKSortedList().mergeKLists(new ListNode[] {listNode, listNode1});
		System.out.println(mergeKLists.toString());
	}
}
