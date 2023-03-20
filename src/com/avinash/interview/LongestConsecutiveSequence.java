package com.avinash.interview;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

	/**
	 * Given an unsorted array of integers nums, return the length of the longest
	 * consecutive elements sequence.
	 * 
	 * You must write an algorithm that runs in O(n) time.
	 * 
	 * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
	 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	 * 
	 * Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
	 * 
	 * 
	 */
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int max = 0;
		for (int num : nums) {
			int left = num - 1;
			int right = num + 1;
			int count = 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
