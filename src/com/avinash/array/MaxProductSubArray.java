package com.avinash.array;

import java.util.Arrays;

public class MaxProductSubArray {
	
	public static int maxProduct(int[] nums) {
		int result = Arrays.stream(nums).max().getAsInt();
		int curMax = 1;
		int curMin = 1;
		for (int num : nums) {
			if (num != 0) {
				int temp = curMax * num;
				curMax = Math.max(curMax * num, Math.max(curMin * num, num));
				curMin = Math.min(temp, Math.min(curMin * num, num));
				result = Math.max(curMax, result);
			} 
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {-1, -2, -3}));

		System.out.println(maxProduct(new int[] {2, 4, -3, 5}));
	}

}
