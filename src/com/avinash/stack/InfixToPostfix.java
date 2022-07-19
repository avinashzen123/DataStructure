package com.avinash.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

public class InfixToPostfix {

	public static int operatorPrecedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	
//	/Users/avinashsharma/Documents/GitHub/DataStructure/src/com/avinash

	public static String infixToPostfix(String exp) {
		String result = "";

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.empty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.empty() && operatorPrecedence(c) <= operatorPrecedence(stack.peek())) {
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.empty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(exp));

	}
}
