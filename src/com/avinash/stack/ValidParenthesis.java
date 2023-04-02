package com.avinash.stack;

import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthesis {

	public boolean isValid(String s) {
        Map<Character, Character> mapping = Map.of('}', '{', ')', '(', ']', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (mapping.containsKey(ch)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if(mapping.get(ch)  != topElement) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		System.out.println(new ValidParenthesis().isValid("()[]{}"));
	}
}
