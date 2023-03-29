package com.avinash.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/description/
public class ContiguousArrayWithEqual1And0 {
	static class BruteForce {
		// Time complexity : O(n ^ 2)
		static int findMaxLength(int[] nums) {
	        int maxLength = 0;
	        for (int i = 0; i < nums.length; i++) {
	        	int zero = 0;
	        	int one = 0;
	        	for (int j = i; j < nums.length; j++) {
	        		if (nums[j] == 1) {
	        			one++;
	        		} else {
	        			zero++;
	        		}
	        		if (one == zero) {
		        		maxLength = Math.max(maxLength, (j - i + 1));
		        	}
	        	}
	        }
	        return maxLength;
	    }
	}
	
	static class UsingHashMap {
		static int findMaxLength(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(0, -1);
			int count = 0;
			int maxLength = 0;
			for (int i = 0; i < nums.length; i++) {
				count += nums[i] == 1 ? 1 : -1;
				if (map.containsKey(count)) {
					maxLength = Math.max(maxLength, i - map.get(count) );
				} else {
					map.put(count, i);
				}
			}
			return maxLength;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(UsingHashMap.findMaxLength(new int[] {0, 1}));
		System.out.println(UsingHashMap.findMaxLength(new int[] {0, 1, 0}));
	}
}
