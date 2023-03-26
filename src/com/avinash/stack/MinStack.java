package com.avinash.stack;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/description/
/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object. void push(int val) pushes the
 * element val onto the stack. void pop() removes the element on the top of the
 * stack. int top() gets the top element of the stack. int getMin() retrieves
 * the minimum element in the stack.
 * 
 * You must implement a solution with O(1) time complexity for each function.
 * 
 *
 */
class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);
		minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}