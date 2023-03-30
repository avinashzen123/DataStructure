package com.avinash.random;

import java.util.ArrayList;

/**
 * 
 * https://leetcode.com/problems/linked-list-random-node/description/
 * 
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Implement the Solution class:
 * 
 * Solution(ListNode head) Initializes the object with the head of the
 * singly-linked list head. int getRandom() Chooses a node randomly from the
 * list and returns its value. All the nodes of the list should be equally
 * likely to be chosen.
 * 
 *
 */
public class RandomPickListNode {
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
	}

	static class FixedRangeSampling {
		private ArrayList<Integer> range = new ArrayList<>();

		public FixedRangeSampling(ListNode head) {
			while (head != null) {
				this.range.add(head.val);
				head = head.next;
			}
		}

		/**
		 * Time complexity : O(N)
		 * 
		 * won't work on growable list.
		 */
		public int getRandom() {
			int pick = (int) (Math.random() * this.range.size());
			return this.range.get(pick);
		}
	}

	static class ReservoidSampling {
		// Unknown size;
		private ListNode head;

		public ReservoidSampling(ListNode node) {
			this.head = node;
		}

		public int getRandom() {
			int scope = 1;
			int chosenValue = 0;
			ListNode curr = this.head;
			while (curr != null) {
				if (Math.random() < 1.0 / scope) {
					chosenValue = curr.val;
				}
				scope++;
				curr = curr.next;
			}
			return chosenValue;
		}
	}
}
