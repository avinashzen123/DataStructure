package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {
	/*
	 * https://leetcode.com/problems/largest-rectangle-in-histogram/
	 * 
	 * Given an array of integers heights representing the histogram's bar height
	 * where the width of each bar is 1, return the area of the largest rectangle in
	 * the histogram.
	 * 
	 * Input: heights = [2,1,5,6,2,3]
	 * 
	 * Output: 10
	 * 
	 * Explanation: The above is a histogram where width of each bar is 1. The
	 * largest rectangle is shown in the red area, which has an area = 10 units.
	 * 
	 */

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] leftMin = new int[n];
		Stack<Integer> left = new Stack<>();
		Arrays.fill(leftMin, -1);
		for (int i = heights.length - 1; i >= 0; i--) {
			while (!left.isEmpty() && heights[left.peek()] > heights[i]) {
				leftMin[left.pop()] = i;
			}
			left.add(i);
		}
		int[] rightMin = new int[n];
		Stack<Integer> right = new Stack<>();
		Arrays.fill(rightMin, heights.length);
		for (int i = 0; i < heights.length; i++) {
			while (!right.isEmpty() && heights[right.peek()] > heights[i]) {
				rightMin[right.pop()] = i;
			}
			right.add(i);
		}
		int area = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			area = Math.max(area, heights[i] * (rightMin[i] - leftMin[i] - 1));
		}
		return area;

	}

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 1, 2, 3, 4, 5, 11 }));
		System.out.println(largestRectangleArea(new int[] {1, 3, 3, 2, 4, 1, 5, 3, 2}));
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}
}
