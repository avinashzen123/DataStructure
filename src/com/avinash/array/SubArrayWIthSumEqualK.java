package com.avinash.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArrayWIthSumEqualK {
	static class CumulativeSum {
		// Time complexity O(n^2)
		static int subarraySum(int[] nums, int k) {
	        int[] cumSum = new int[nums.length + 1];
	        for (int i = 1; i <= nums.length; i++) {
	        	cumSum[i] = cumSum[i - 1] + nums[i - 1];
	        }
	        int count = 0;
	        for (int i = 0; i <= nums.length; i++) {
	        	for (int j = i + 1; j <= nums.length; j++) {
	        		if (cumSum[j] - cumSum[i] == k) {
	        			count++;
	        		}
	        	}
	        }
	        return count;
	    }
	}
	
	static class WithoutSpace {
		// Time complexity O(n ^ 2)
		static int subarraySum(int[] nums, int k) {
			int count = 0;
			for (int start = 0; start < nums.length; start++) {
				int sum = 0;
				for (int end = start; end < nums.length; end++) {
					sum += nums[end];
					if (sum == k) count++;
				}
			}
			return count;
		}
	}
	
	static class UsingHashMap {
		static int subarraySum(int[] nums, int k) {
			int count = 0;
			int sum = 0;
			Map<Integer, Integer> map = new HashMap<>();
			map.put(0, 1);
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				if (map.containsKey(sum - k)) {
					count += map.get(sum - k);
				}
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
			return count;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(CumulativeSum.subarraySum(new int[] {1, 1, 1}, 2));
		System.out.println(WithoutSpace.subarraySum(new int[] {1, 1, 1}, 2));
		System.out.println(UsingHashMap.subarraySum(new int[] {1, 1, 1}, 2));
	}
}
