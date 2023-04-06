package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {
	
	public static void main(String[] args) {
		int[] array = {-5, 2, -2, 4, 3, 1};
		Stack<Integer> stack = new Stack<>();
		Arrays.stream(array).forEach(stack::push);
		System.out.println(new SortStack().sortStack(stack));
	}

	private Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> tmpStack = new Stack<>();
		while(!stack.isEmpty()) {
			Integer tmp = stack.pop();
			while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
				stack.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}
}
