package com.avinash.linkedlist;

public class DetectCycle {
	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
	
	
	public static LinkedList detectCycle(LinkedList head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedList fast = head;
        LinkedList slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null && slow != fast);
        fast = head;
        while(slow != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

	public static void main(String[] args) {
		LinkedList zero = new LinkedList(0);
		LinkedList one = new LinkedList(1);
		LinkedList two = new LinkedList(2);
		LinkedList three = new LinkedList(3);
		LinkedList four = new LinkedList(4);
		LinkedList five = new LinkedList(5);
		LinkedList six = new LinkedList(6);
		LinkedList seven = new LinkedList(7);
		LinkedList eight = new LinkedList(8);
		LinkedList nine = new LinkedList(9);
		zero.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = nine;
		nine.next = four;
		
		System.out.println(detectCycle(one).value);
	}
}
