package com.avinash.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/description/
public class BasicCalculator1 {
	public static int calculate1(String s) {
		Stack<Integer> stack = new Stack<>();
		Integer operand = 0;
		for (Character token : s.toCharArray()) {
			if (Character.isDigit(token)) {
				operand += operand * 10 + (int)token - '0';
			} else if ("+-/*".contains(token.toString())) {
				switch (token.toString()) {
				case "+":
					stack.push(operand);
					break;
				case "-":
					stack.push(-operand);
					break;
				case "*":
					stack.push(stack.pop() * operand);
					break;
				case "/":
					stack.push(stack.pop() / operand);
					break;
				}
				operand = 0;
			}
		}
		return stack.stream().reduce(0, (i, j) -> i + j);
	}
	
	public static int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
//            if ("+-*/".contains(currentChar+"")) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
	}
}
