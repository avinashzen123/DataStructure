package com.avinash.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int lSeq = Integer.MIN_VALUE;
		int cSeq = 0;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				while (set.contains(num++)) {
					cSeq++;
				}
				lSeq = Math.max(lSeq, cSeq);
				cSeq = 0;
			}
		}
		return lSeq;
	}

	public int longestConsecutive1(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int maxLen = 0;
		for (int num : nums) {
			int left = num - 1;
			int right = num + 1;
			int count = 1;
			while (set.contains(left)) {
				set.remove(left);
				left--;
				count++;
			}
			while (set.contains(right)) {
				set.remove(right);
				right++;
				count++;
			}
			maxLen = Math.max(maxLen, count);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new LongestConsecutiveSequence().longestConsecutive1(nums));
	}
}
