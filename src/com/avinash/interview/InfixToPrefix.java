package com.avinash.interview;

import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convertInfixToPrefix(exp));
	}
	
	public static String convertInfixToPrefix(String str) {
		StringBuffer buffer = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (Character c : str.toCharArray()) {
			if (Character.isLetterOrDigit(c)) buffer.append(c);
			else if (c.equals('(')) stack.add(c);
			else if (c.equals(')')) {
				while (!stack.empty() && !stack.peek().equals('(')) 
					buffer.append(stack.pop());
				stack.pop();
			} else {
				while(!stack.empty() && operatorPrecedence(c) <= operatorPrecedence(stack.peek())) {
					buffer.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.empty()) {
			if (stack.peek().equals('(')) return "Invalid expression";
			buffer.append(stack.pop());
		}
		return buffer.toString();
	}

	private static int operatorPrecedence(Character c) {
		if (c.equals('+') || c.equals('-')) return 1;
		if (c.equals('*') || c.equals('/')) return 2;
		if (c.equals('^')) return 3;
		return -1;
	}
}
