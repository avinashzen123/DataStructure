package com.avinash.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/remove-invalid-parentheses/description/
/**
 * Given a string s that contains parentheses and letters, remove the minimum
 * number of invalid parentheses to make the input string valid.
 * 
 * Return a list of unique strings that are valid with the minimum number of
 * removals. You may return the answer in any order.
 * 
 * Input: s = "()())()" 
 * Output: ["(())()","()()()"]
 */
public class RemoveInvalidParenthesis {
	static class BackTracking {
		private Set<String> validExpression = new HashSet<>	();
		private int minimumRemoved;
		
		private void reset() {
			this.validExpression.clear();
			this.minimumRemoved = Integer.MAX_VALUE;
		}
		
		// Time complexity : O(2 ^ n)
		public List<String> removeInvalidParenthesis(String s) {
			this.reset();
			this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
			return new ArrayList<>(this.validExpression);
		}

		private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removeCount) {
			if (index == s.length()) {
				if (leftCount == rightCount) {
					if (removeCount <= this.minimumRemoved) {
						String possibleAnswer = expression.toString();
						if (removeCount < this.minimumRemoved) {
							this.validExpression.clear();
							this.minimumRemoved = removeCount;
						}
						this.validExpression.add(possibleAnswer);
					}
				}
			} else {
				char currentChar = s.charAt(index);
				int length = expression.length();
				if (currentChar != '(' && currentChar != ')') {
					expression.append(currentChar);
					this.recurse(s, index + 1, leftCount, rightCount, expression, removeCount + 1);
					expression.deleteCharAt(index);
				} else {
					this.recurse(s, index + 1, leftCount , rightCount, expression, removeCount + 1);
					expression.append(currentChar);
					if (currentChar == '(') {
						this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removeCount);
					} else if (rightCount < leftCount) {
						this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removeCount);
					}
					expression.deleteCharAt(length);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new BackTracking().removeInvalidParenthesis("()())()"));
	}
}
