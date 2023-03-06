package com.avinash.array;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarrayWithSumK {
	public int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			prefixSum += num;
			int complementSum = prefixSum - k;
			if (complementSum == 0) {
				maxLength = i + 1;
			} else if (map.containsKey(complementSum)) {
				maxLength = Math.max(maxLength, i - map.get(complementSum));
			}
			map.putIfAbsent(prefixSum, i);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxSizeSubarrayWithSumK().maxSubArrayLen(new int[] {1,-1,5,-2,3}, 3));
	}
}
