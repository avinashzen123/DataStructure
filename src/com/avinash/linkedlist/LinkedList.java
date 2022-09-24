package com.avinash.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class LinkedList {
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void traverse(ListNode root) {
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		head = reverseLinkedListIter(head);
		traverse(head);
		head = reverseLinkedListRec(head, null);
		traverse(head);
		
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(8, new ListNode(11, null)))));
		ListNode head2 = new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(9, new ListNode(12, null)))));
		ListNode mergedHead = mergeTwoSortedList(head1, head2);
		traverse(mergedHead);
		
		reorderList(mergedHead);
		traverse(mergedHead);
	}

	private static void reorderList(ListNode node) {
		if (node == null || node.next == null) return;
		ListNode slow = node;
		ListNode fast = node.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// reverse nextHalf
		ListNode secondHalf = slow.next;
		ListNode prevNode = null;
		slow.next = null;
		while (secondHalf != null) {
			ListNode tmpNode = secondHalf.next;
			secondHalf.next = prevNode;
			prevNode = secondHalf;
			secondHalf = tmpNode;
		}
		secondHalf = prevNode;
		while (secondHalf != null) {
			ListNode tmp1 = node.next;
			ListNode tmp2 = secondHalf.next;
			node.next = secondHalf;
			secondHalf.next = tmp1;
			node = tmp1;
			secondHalf = tmp2;
		}
		
		
	}

	private static ListNode mergeTwoSortedList(ListNode node1, ListNode node2) {
		ListNode node = new ListNode();
		ListNode tmpNode = node;
		while(node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				tmpNode.next = node1;
				node1 = node1.next;
			} else {
				tmpNode.next = node2;
				node2 = node2.next;
			}
			tmpNode = tmpNode.next;
		}
		tmpNode.next = node1 == null ? node2 : node1;
		return node.next;
	}

	private static ListNode reverseLinkedListRec(ListNode curNode, ListNode prevNode) {
		if(curNode == null) return prevNode;
		ListNode tmpNode = curNode.next;
		curNode.next = prevNode;
		prevNode = curNode;
		return reverseLinkedListRec(tmpNode, prevNode);
	}

	private static ListNode reverseLinkedListIter(ListNode head) {
		ListNode curNode  = head;
		ListNode prevNode = null;
		while(curNode != null) {
			ListNode tmpNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = tmpNode;
		}		
		return prevNode;
	}
}
