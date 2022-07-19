package com.avinash.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	private Queue<Integer> queue1 = new LinkedList<>();
	private Queue<Integer> queue2 = new LinkedList<>();
	
	private int currSize = 0;
	
	public void push(int x) {
		currSize++;
		queue2.add(x);
		while(!queue1.isEmpty()) {
			queue2.add(queue1.poll());
		}
		Queue<Integer> queue = queue1;
		queue1 = queue2;
		queue2 = queue;
	}
	
	public Integer pop() {
		if (queue1.isEmpty()) {
			return null;
		}
		currSize--;
		return queue1.poll();
	}
	
	public int top() {
		if (queue1.isEmpty()) {
			return -1;
		}
		return queue1.peek();
	}
	
	public int size() {
		return currSize;
	}
	
	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		
		s.push(1);
        s.push(2);
        s.push(3);
  
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
  
        System.out.println("current size: " + s.size());

	}
	
}
