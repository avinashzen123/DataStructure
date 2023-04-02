package com.avinash.stack;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParenthesis {

	static class BruteForce {
		public int longestValidParenthesis(String s) {
			int maxLen = 0;
	        for (int i = 0; i < s.length(); i++) {
	        	for (int j = s.length() - 1; j >= i + 2; j --) {
	        		if (isValid(s.substring(i, j))) {
	        			maxLen = Math.max(maxLen, j - i);
	        		}
	        	}
	        }
	        return maxLen;
	    }
		private boolean isValid(String s) {
			Stack<Character> stack = new Stack<>();
			for (char ch : s.toCharArray()) {
				if (ch == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						return false;
					}
				} else {
					stack.push(ch);
				}
			}
			return stack.isEmpty();
		}
	}
	
	static class UsingStack {
		public int longestValidParenthesis(String s) {
			Stack<Integer> stack = new Stack<>();
			stack.push(-1);
			int maxLen = 0;
			for (int i = 0; i < s.length(); i++ ) {
				char ch = s.charAt(i);
				if (ch == '(') {
					stack.push(i);
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						stack.push(i);
					} else {
						System.out.println(i+" Peeked character " + stack.peek()+  " " + s.charAt(stack.peek()));
						maxLen = Math.max(maxLen, i - stack.peek());
					}
				}
			}
			return maxLen;
		}
	}
	
	static class UsingDP {
		public int longestValidParenthesis(String s) {
			int maxLen = 0;
			int[] dp = new int[s.length()];
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					if (s.charAt(i - 1) == '(') {
						dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
					} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1]-1) == '(') {
						dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
					}
				}
				maxLen = Math.max(maxLen, dp[i]);
			}
			return maxLen;
		}
	}
	
	static class WithoutExtraSpace {
		public int longestValidParenthesis(String s) {
			int left = 0;
			int right = 0;
			int maxLen = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '(') {
					left ++;
				} else {
					right ++;
				}
				if (left == right) {
					maxLen = Math.max(maxLen, 2 * left);
				} else if (right > left) {
					left = 0;
					right = 0;
				}
			}
			left = right = 0;
			for (int i = s.length() - 1; i >=0 ;i--) {
				char ch = s.charAt(i);
				if (ch == '(') {
					left ++;
				} else {
					right ++;
				}
				if (left == right) {
					maxLen = Math.max(maxLen, 2 * left);
				} else if (left > right) {
					left = 0;
					right = 0;
				}
			}
			return maxLen;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(new WithoutExtraSpace().longestValidParenthesis("))()())"));
		System.out.println(new WithoutExtraSpace().longestValidParenthesis("(()"));
	}
}
