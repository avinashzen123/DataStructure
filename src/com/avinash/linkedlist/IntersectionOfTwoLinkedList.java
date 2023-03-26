package com.avinash.linkedlist;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aNodes = new HashSet<>();
        ListNode curA = headA;
        while(curA != null) {
            aNodes.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null) {
            if (aNodes.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
	}
	
	public static void main(String[] args) {
		
	}
}
