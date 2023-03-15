package com.avinash.array;

import java.util.ArrayList;
import java.util.HashMap;

public class SplitArrayWithEqualSum {
	/**
	 * Time complexity : O(n^4)
	 */
	private static class BruteForce {
		private int sum(int[] array, int left, int right) {
			int sum = 0;
			for (int i = left; i < right; i++) {
				sum += array[i];
			}
			return sum;
		}
		
		 public boolean splitArray(int[] nums) {
			 if (nums.length < 7) {
				 return false;
			 }
			 for (int first = 1; first < nums.length - 5; first++) {
				 int sumFirst = sum(nums, 0, first);
				 for (int second = first + 2; second < nums.length - 2; second++) {
					 int sumSecond = sum(nums, first + 1, second);
					 for (int third = second + 2; third < nums.length; third++) {
						 int sumThird = sum(nums, second + 1, third);
						 int sumFourth = sum(nums, third + 1, nums.length);
						 if (sumFirst == sumSecond && sumSecond == sumThird && sumThird == sumFourth) {
							 return true;
						 }
					 }
				 }
			 }
			 return false;
		 }
	}

	private static class CumulativSum {
		/*
		 * Time complexity : O(N ^ 3)
		 */
		public boolean splitArray(int[] nums) {
			if (nums.length < 7) {
				return false;
			}
			int[] sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = sums[i-1] + nums[i];
			}
			for (int first = 1; first < nums.length; first++) {
				int sum1 = sums[first - 1];
				for (int second = first + 2; second < nums.length - 3; second++) {
					int sum2 = sums[second - 1] - sums[first];
					if (sum1 != sum2) {
						continue;
					}
					for (int third = second + 2; third < nums.length ; third++) {
						int sum3 = sums[third - 1] - sums[second];
						int sum4 = sums[nums.length - 1] - sums[third];
						if (sum2 == sum3 && sum4 == sum3) {
							return true;
						}
					}
				}
			}
			return false;
	    }
	}
	
	private static class UsingHashMap {
		public boolean splitArray(int[] nums) {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			int summ = 0;
			int tot = 0;
			for (int i = 0; i < nums.length; i++) {
				summ += nums[i];
				if (!map.containsKey(summ)) {
					map.put(summ, new ArrayList<>());
				} 
				map.get(summ).add(i);
			}
			summ = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (map.containsKey(2 * summ + nums[i])) {
					for (int j : map.get(2 * summ + nums[i])) {
						j++;
						if (j > i + 1 && j < nums.length - 3 
								&& map.containsKey(3 * summ + nums[i] + nums[j])) {
							
						}
					}
				}
			}
			return false;
		}
	}
	
}
