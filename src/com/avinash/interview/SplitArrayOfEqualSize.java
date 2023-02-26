package com.avinash.interview;

import java.util.*;

public class SplitArrayOfEqualSize {

	private static class BruteForce {
		public int sum(int[] nums, int i, int j) {
			int sum = 0;
			while (i < j) {
				sum += nums[i++];
			}
			return sum;
		}

		/*
		 * Time complexity : O(n^4)
		 */
		public boolean splitArray(int[] nums) {
			if (nums.length < 7)
				return false;

			for (int i = 1; i < nums.length - 5; i++) {
				int sum1 = sum(nums, 0, i);
				for (int j = i + 2; j < nums.length - 3; j++) {
					int sum2 = sum(nums, i + 1, j);
					for (int k = j + 2; k < nums.length; k++) {
						int sum3 = sum(nums, j + 1, k);
						int sum4 = sum(nums, k + 1, nums.length);
						if (sum1 == sum2 && sum3 == sum4 && sum2 == sum4) {
							System.out.println("i = " + i + " j = " + j + " k = " + k);
							return true;
						}
					}
				}
			}
			return false;
		}
	}

	private static class CumulativeSum {
		/*
		 * Time complexity O(n^3)
		 */
		public boolean splitArray(int[] nums){
			if (nums.length < 7)
				return false;
			int[] sum = new int[nums.length];
			sum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sum[i] = sum[i - 1] + nums[i];
			}
	        
			for (int i = 1; i < nums.length; i++) {
				int sum1 = sum[i-1];
				for (int j = i + 2; j < nums.length; j ++) {
					int sum2 = sum[j- 1] - sum[i];
					if (sum1 != sum2) continue;
					for (int k = j + 2; k < nums.length; k ++) {
						int sum3 = sum[k - 1] - sum[j];
						int sum4 = sum[nums.length - 1] - sum[k];
						if (sum1 == sum2 && sum3 == sum4 && sum2 == sum4) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	private static class HashMapSum {
		
		public boolean splitArray(int[] nums) {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			int sum = 0;
			int tot = 0;
			
			for (int i = 0; i < nums.length; i++) {
				sum  += nums[i];
				if (map.containsKey(sum)) {
					map.get(sum).add(i);
				} else {
					map.put(sum, new ArrayList<>(List.of(i)));
				}
				tot += nums[i];
			}
			sum = nums[0];
			for (int i = 1; i < nums.length - 5; i++) {
				if (map.containsKey(2 * sum + nums[i])) {
					for (int j : map.get(2 * sum + nums[i])) {
						
					}
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(new BruteForce().splitArray(new int[] { 1, 2, 1, 2, 1, 2, 1 }));
		System.out.println(new CumulativeSum().splitArray(new int[] { 1, 2, 1, 2, 1, 2, 1 }));
	}
}
