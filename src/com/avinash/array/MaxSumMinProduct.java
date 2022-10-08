package com.avinash.array;

import java.util.Arrays;
import java.util.Stack;

public class MaxSumMinProduct {

	/*
	 * https://leetcode.com/problems/maximum-subarray-min-product/
	 * 
	 * The min-product of an array is equal to the minimum value in the array
	 * multiplied by the array's sum.
	 * 
	 * For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 *
	 * (3+2+5) = 2 * 10 = 20. Given an array of integers nums, return the maximum
	 * min-product of any non-empty subarray of nums. Since the answer may be large,
	 * return it modulo 109 + 7.
	 * 
	 * Note that the min-product should be maximized before performing the modulo
	 * operation. Testcases are generated such that the maximum min-product without
	 * modulo will fit in a 64-bit signed integer.
	 * 
	 * A subarray is a contiguous part of an array
	 * 
	 * Input: nums = [1,2,3,2] Output: 14 Explanation: The maximum min-product is
	 * achieved with the subarray [2,3,2] (minimum value is 2). 2 * (2+3+2) = 2 * 7
	 * = 14.
	 * 
	 * 
	 * Input: nums = [2,3,3,1,2] Output: 18 Explanation: The maximum min-product is
	 * achieved with the subarray [3,3] (minimum value is 3). 3 * (3+3) = 3 * 6 =
	 * 18.
	 * 
	 * https://www.youtube.com/watch?v=YLesLbNkyjA
	 * 
	 */
	public static int maxSumMinProduct(int[] nums) {

		int mode = (int) 1e9 + 7;
		long prefSum[] = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			prefSum[i + 1] = prefSum[i] + nums[i];
		}

		long maxProd = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(prefSum));
		for (int index = 0; index <= nums.length; index++) {
			while (stack.peek() != -1 && (index == nums.length || nums[stack.peek()] > nums[index])) {
				System.out.println("--------- " + stack.toString());
				
				int curMinIndex = stack.pop();
				int prevPrevIndex = stack.peek();
				long sum = prefSum[index] - prefSum[prevPrevIndex + 1];
				long curProd = nums[curMinIndex] * sum;
				
				System.out.println(index + " prevIndex " + curMinIndex + " prevPrevIndex " + prevPrevIndex
						+ " prefSum[index]  " + prefSum[index] + " prefSum[prevPrevIndex + 1] "
						+ prefSum[prevPrevIndex + 1] + " sum " + sum + " curProd " + curProd + " " + Arrays.toString(Arrays.copyOfRange(nums, prevPrevIndex + 1, curMinIndex + 1)));
				
				maxProd = Math.max(maxProd, curProd);

			}
			stack.push(index);
		}
		return (int) (maxProd % mode);
	}

	public static void main(String[] args) {
		System.out.println(maxSumMinProduct(new int[] { 1, 2, 3, 2 }));
	}
}
