package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * Input: numRows = 5 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 */
public class PascalTraingle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(List.of(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(1);
			List<Integer> prev = result.get(i - 1);
			for (int j = 1; j < i; j++) {
				row.add(prev.get(j - 1) + prev.get(j));
			}
			row.add(1);
			result.add(row);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
}
