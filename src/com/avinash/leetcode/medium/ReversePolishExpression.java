package com.avinash.leetcode.medium;

import java.util.Stack;

public class ReversePolishExpression {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (!"*-/+".contains(token)) {
				stack.push(Integer.valueOf(token));
				continue;
			}
			Integer number2 = stack.pop();
			Integer number1 = stack.pop();
			switch(token) {
			case "*":
				stack.push(number1 * number2);
				break;
			case "/":
				stack.push(number1 / number2);
				break;
			case "-":
				stack.push(number1 - number2);
				break;
			case "+":
				stack.push(number1 + number2);
				break;
				
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(evalRPN(tokens));
		System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
	}
}
