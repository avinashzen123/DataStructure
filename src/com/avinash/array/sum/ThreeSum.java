package com.avinash.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	static class UsingSort {
		// Time complexity : O(n^2)
		static List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			Arrays.sort(nums);
			for (int i = 0; i < nums.length; i++) {
				if (i == 0 || nums[i - 1] != nums[i])
					threeSum(nums, i, result);
			}
			return result;
		}

		private static void threeSum(int[] nums, int index, List<List<Integer>> result) {
			int left = index + 1;
			int right = nums.length - 1;
			while (left < right) {
				int curSum = nums[index] + nums[left] + nums[right];
				if (curSum < 0) {
					left++;
				} else if (curSum > 0) {
					right--;
				} else {
					result.add(List.of(nums[index], nums[left++], nums[right]));
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				}
			}
		}
	}

	static class UsingHashSet {
		// Time Complexity : O(n ^ 2)
		static List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (i == 0 || nums[i] != nums[i - 1]) {
					twoSum(nums, i, result);
				}
			}
			return result;
		}

		private static void twoSum(int[] nums, int index, List<List<Integer>> result) {
			Set<Integer> seen = new HashSet<>();
			for (int i = index + 1; i < nums.length; i++) {
				int complement = -nums[i] - nums[index];
				if (seen.contains(complement)) {
					result.add(Arrays.asList(nums[index], nums[i], complement));
					while (i + 1 < nums.length && nums[i] == nums[i + 1])
						i++;
				}
				seen.add(nums[i]);
			}
		}
	}

	static class NoSort {
		// Time complexity : O(n^2)
		static List<List<Integer>> threeSum(int[] nums) {
			Set<List<Integer>> res = new HashSet<>();
			Set<Integer> dups = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				int numI = nums[i];
				if (dups.add(numI)) {
					Set<Integer> seen = new HashSet<>();
					for (int j = i + 1; j < nums.length; j++) {
						int numJ = nums[j];
						int complement = -numI - numJ;
						if (seen.contains(complement)) {
							List<Integer> triplet = Arrays.asList(numI, numJ, complement);
							Collections.sort(triplet);
							res.add(triplet);
						}
						seen.add(numJ);
					}
				}
			}
			return new ArrayList<>(res);
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(NoSort.threeSum(nums));
		System.out.println(UsingHashSet.threeSum(nums));
		System.out.println(UsingSort.threeSum(nums));
	}
}
