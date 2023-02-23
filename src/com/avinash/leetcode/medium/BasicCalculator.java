package com.avinash.leetcode.medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicCalculator {
	
	public static int calculate(String str) {
		Stack<Integer> stack  = new Stack<>();
		int operand = 0;
		int result = 0;  //for ongoing result
		int sign = 1; // 1 means positive, -1 means negative
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				// Forming operand since it could be more than one digit.
				operand = 10 * operand + (int)(ch - '0');
			} else if (ch == '+') {
				// Evaluate the expression to the left with result, sign operand
				result += sign * operand;
				// Save the recently encountered '+' sign
				sign = 1;
				// Reset operand
				operand = 0;
			} else if (ch == '-') {
				// Evaluate the expression 
				result += sign * operand;
				sign = -1;
				operand = 0;
			} else if (ch == '(') {
				// Push the result and sign on to the stack, for later 
				// We push the result first the sign
				stack.push(result);
				stack.push(sign);
				// Reset operand and result, as if new evaluation begins for the new sub-expression
				sign = 1;
				result = 0;
			} else if (ch == ')') {
				// Evaluate the expression to the left with the result, sign and operand
				result += sign * operand;
				// ')' marks end of expression within a set of parenthesis its result is multiplied with
				// with sign on top of stack as stack.pop() is sign before the parenthesis.
				result *= stack.pop();
				// The add to the next operand on the top as stack.pop() is the result calculated before this 
				// Parenthesis (operand on stack) + (sign on stack * (result from parenthesis))
				result += stack.pop();
				// reset the operand.
				operand = 0;
			}
		}
		return result + (sign * operand);
	}

	public static void main(String[] args) {
		
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		
		String expression = "(1+(4+5+2)-3)+(66+8)";
		System.out.println(calculate(expression));
		Pattern pattern =  Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(expression);
		while(matcher.find()) {
			System.out.println(expression.substring(matcher.start(), matcher.end()));
		}
	}
}
