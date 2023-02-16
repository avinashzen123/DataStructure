package com.avinash.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public void push(int x) {
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack2.push(x);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
	}

	public int pop() {
		if (stack1.isEmpty()) throw new EmptyStackException();
		return stack1.pop();
	}

	public int peek() {
		if (stack1.isEmpty()) throw new EmptyStackException();
		return stack1.peek();
	}

	public boolean empty() {
		return stack1.isEmpty();
	}
	
	public static void main(String[] args) {
		QueueUsingStack queueUsingStack = new QueueUsingStack();
		queueUsingStack.push(1);
		queueUsingStack.push(2);
		queueUsingStack.push(3);
		queueUsingStack.push(4);
		System.out.println(queueUsingStack.peek());
		System.out.println(queueUsingStack.pop());
		System.out.println(queueUsingStack.peek());
		System.out.println(queueUsingStack.pop());
		System.out.println(queueUsingStack.peek());
		System.out.println(queueUsingStack.pop());
	}
}
