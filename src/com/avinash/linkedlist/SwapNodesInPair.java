package com.avinash.linkedlist;

import lombok.ToString;

public class SwapNodesInPair {
	@ToString
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
	}

	/*
	 * 1 -> 2 -> 3 -> 4 2 -> 1 -> 4 -> 3
	 */
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head;
		ListNode nextNextNode = nextNode.next;
		ListNode newNode = nextNode;
		while (nextNode != null && nextNextNode != null) {
			Integer tmp = nextNode.val;
			nextNode.val = nextNextNode.val;
			nextNextNode.val = tmp;
			nextNode = nextNextNode.next;
			if (nextNode != null) {
				nextNextNode = nextNode.next;
			}
		}
		return newNode;
	}

	public ListNode swapNodes(ListNode head, int k) {
//       ListNode kthNodeStart = head;;
//       ListNode KthNodeEnd = null;

//       int index = 1;
//       while(index < k) {
//           kthNodeStart = kthNodeStart.next;
//           index ++;
//       }
//       Stack<ListNode> stack = new Stack<>();
//       ListNode tmp = head;
//       while(tmp != null) {
//           stack.push(tmp);
//           tmp = tmp.next;
//       }
//       index = 1;
//       while(index <= k) {
//           KthNodeEnd = stack.pop();
//           index++;
//       }
//       int val = kthNodeStart.val;
//       kthNodeStart.val= KthNodeEnd.val;
//       KthNodeEnd.val = val;
//       return head;

		if (head == null)
			return head;
		ListNode p = head, end = null, begin = null;
		for (int i = 1; i < k; i++) {
			if (p != null)
				p = p.next;
		}
		begin = p;
		while (p != null) {
			if (end == null) {
				end = head;
			} else {
				end = end.next;
			}
			p = p.next;
		}
		int temp = 0;
		temp = begin.val;
		begin.val = end.val;
		end.val = temp;

		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		System.out.println(head);
		ListNode swapped = swapPairs(head);
		System.out.println(swapped);
	}
}
