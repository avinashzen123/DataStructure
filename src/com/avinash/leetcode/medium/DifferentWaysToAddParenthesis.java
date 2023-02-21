package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DifferentWaysToAddParenthesis {
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		Set<Character> operator = Set.of('+', '-', '/', '*');
		for (int i = 0; i < input.length(); i++) {
			char curChar = input.charAt(i);
			if (operator.contains(curChar)) {
				List<Integer> part1Result = diffWaysToCompute(input.substring(0, i));
				List<Integer> part2Result = diffWaysToCompute(input.substring(i + 1));
				for (Integer p1 : part1Result) {
					for (Integer p2 : part2Result) {
						int c = 0;
						switch (curChar) {
						case '+': 
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '/':
							c = p1 / p2;
							break;
						case '*':
							c = p1 * p2;
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + curChar);
						}
						result.add(c);
					}
				}
			}
		}
		if (result.size() == 0) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1/1"));
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}
	
}
