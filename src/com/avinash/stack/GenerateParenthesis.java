package com.avinash.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParenthesis {

		public static List<String> generateParenthesis (int n) {
			List<String> result = new ArrayList<>();
			backTrack(0, 0, n, new Stack<>(), result);
			return result;
		}

		private static void backTrack(int open, int close, int n, Stack<Character> stack, List<String> result) {
			if (open == close && open == n) {
				result.add(stack.stream().map(c -> c+ "").collect(Collectors.joining()));
				return;
			}
			if (open < n) {
				stack.push('(');
				backTrack(open + 1, close, n, stack, result);
				stack.pop();
			}
			if (close <open) {
				stack.push(')');
				backTrack(open, close + 1, n, stack, result);
				stack.pop();
			}
		}
		
		public static void main(String[] args) {
			System.out.println(generateParenthesis(4));
		}
	
}
