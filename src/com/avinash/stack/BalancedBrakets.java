package com.avinash.stack;

import java.util.Stack;

public class BalancedBrakets {

	public static boolean balancedBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(balancedBrackets("([])(){}(())()()"));
	}
}
