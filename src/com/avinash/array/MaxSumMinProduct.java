package com.avinash.array;

import java.util.Arrays;
import java.util.Stack;

public class MaxSumMinProduct {

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
				System.out.println(index + " prevIndex "+ curMinIndex + " prevPrevIndex " + prevPrevIndex + " prefSum[index]  " + prefSum[index] + " prefSum[prevPrevIndex + 1] " + prefSum[prevPrevIndex + 1] + " sum " + sum + " curProd " + curProd);
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
