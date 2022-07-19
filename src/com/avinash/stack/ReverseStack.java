package com.avinash.stack;

import java.util.Stack;

public class ReverseStack {

	static Stack<Character> reverse(Stack<Character> stack1, Stack<Character> stack2) {
		if (!stack1.empty()) {
			stack2.push(stack1.pop());
			return reverse(stack1, stack2);
		}
		return stack2;
	}
	
	static void reverse(Stack<Character> stack) {
		if (!stack.empty()) {
			Character x = stack.pop();
			reverse(stack);
			
			insertAtBottom(stack, x);
		}
	}

	private static void insertAtBottom(Stack<Character> stack, Character x) {
		if (stack.empty()) {
			stack.push(x);
		} else {
			Character pop = stack.pop();
			insertAtBottom(stack, x);
			stack.push(pop);
		}
	}

	public static void main(String[] args) {
		Stack<Character> st = new Stack<>();
		// push elements into
		// the stack
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');

		System.out.println("Original Stack");

		System.out.println(st);

		// function to reverse
		// the stack

//		st = reverse(st, new Stack<>());
		
		reverse(st);

		System.out.println("Reversed Stack");

		System.out.println(st);
	}
}
