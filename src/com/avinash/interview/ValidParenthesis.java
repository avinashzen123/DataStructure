package com.avinash.interview;

import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

	public static boolean isValidParenthesis(String str) {
		if(str == null) return false;
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
		for (Character ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else if (map.containsValue(ch)){
				if (!stack.isEmpty() && map.get(stack.peek()).equals(ch)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValidParenthesis("(()[])"));
	}
}
