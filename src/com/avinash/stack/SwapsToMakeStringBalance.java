package com.avinash.stack;

import java.util.Stack;

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
/**
 * You are given a 0-indexed string s of even length n. The string consists of
 * exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 * 
 * A string is called balanced if and only if:
 * 
 * It is the empty string, or It can be written as AB, where both A and B are
 * balanced strings, or It can be written as [C], where C is a balanced string.
 * 
 * You may swap the brackets at any two indices any number of times.
 * 
 * Return the minimum number of swaps to make s balanced.
 * 
 * Input: s = "][]["
 * 
 * Output: 1
 * 
 * Explanation: You can make the string balanced by swapping index 0 with index
 * 3. The resulting string is "[[]]".
 * 
 * 
 * Input: s = "]]][[["
 * 
 * Output: 2
 * 
 * Explanation: You can do the following to make the string balanced: - Swap
 * index 0 with index 4. s = "[]][][". - Swap index 1 with index 5. s =
 * "[[][]]". The resulting string is "[[][]]".
 *
 */
public class SwapsToMakeStringBalance {
	static class UsingStack {
		static int minSwaps(String s) {
			Stack<Character> stack = new Stack<>();
			int misMatch = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '[') {
					stack.push(ch);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						misMatch++;
					}
				}
			}
			return (misMatch + 1) / 2;
		}
	}

	static class WithoutStack {
		static int minSwap(String s) {
			int stackSize = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '[') {
					stackSize++;
				} else {
					if (stackSize > 0) {
						stackSize--;
					}
				}
			}
			return (stackSize + 1) / 2;
		}
		
		static int minSwap1(String s) {
			int open = 0; 
			int ans = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ']') {
					if (open > 0) {
						open --;
					} else  {
						ans ++;
						open ++;
					}
				} else {
					open++;
				}
			}
			return ans;
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(UsingStack.minSwaps("]]][[["));
		System.out.println(WithoutStack.minSwap("]]][[["));
		System.out.println(WithoutStack.minSwap1("]]][[["));
	}
}
