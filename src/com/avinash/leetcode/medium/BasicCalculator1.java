package com.avinash.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/description/
public class BasicCalculator1 {
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		Integer operand = 0;
		Character opearion = '+';
		for (Character token : s.toCharArray()) {
			if (Character.isDigit(token)) {
				operand = (operand * 10) + (token - '0');
			} else if ("+-/*".contains(token.toString())) {
				performOperation(stack, opearion, operand);
				operand = 0;
				opearion = token;
			}
		}
		performOperation(stack, opearion, operand);
		return stack.stream().reduce(0, Integer::sum);
	}

	private static void performOperation(Stack<Integer> stack, Character opearion, Integer operand) {
		switch (opearion) {
		case '+':
			stack.push(operand);
			break;
		case '-':
			stack.push(-operand);
			break;
		case '*':
			stack.push(stack.pop() * operand);
			break;
		case '/':
			stack.push(stack.pop() / operand);
			break;
		}
	}

	public static int calculateWithoutStack(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int length = s.length();
		int currentNumber = 0, lastNumber = 0, result = 0;
		char operation = '+';
		for (int i = 0; i < length; i++) {
			char currentChar = s.charAt(i);
			if (Character.isDigit(currentChar)) {
				currentNumber = (currentNumber * 10) + (currentChar - '0');
			}
			if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
				if (operation == '+' || operation == '-') {
					result += lastNumber;
					lastNumber = (operation == '+') ? currentNumber : -currentNumber;
				} else if (operation == '*') {
					lastNumber = lastNumber * currentNumber;
				} else if (operation == '/') {
					lastNumber = lastNumber / currentNumber;
				}
				operation = currentChar;
				currentNumber = 0;
			}
		}
		result += lastNumber;
		return result;

	}

	public static void main(String[] args) {
		System.out.println(calculate("42"));
		System.out.println(calculate("3+2*2"));
	}
}
