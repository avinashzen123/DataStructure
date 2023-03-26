package com.avinash.queue;

// https://leetcode.com/problems/design-most-recently-used-queue/description/
public class MostRecentlyUsedQueue {
	static class Node {
		int val;
		Node next;
		Node prev;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	private static int step = 50;
	Node[] skipNodes;
	Node head;
	int mrQueueLen;
	
	public MostRecentlyUsedQueue(int n) {
		this.mrQueueLen = n;
		int m = n / step;
		skipNodes = new Node[m];
		Node cur = head;
		int idx = 0;
		int j = 1;
		
		for (int i = n - 1; i > 0; i--, j++) {
			Node next = new Node(i);
			cur.next = next;
			next.prev = cur;
			if (j == step) {
				skipNodes[idx++] = next;
				j = 0;
			}
		}
	}
}
