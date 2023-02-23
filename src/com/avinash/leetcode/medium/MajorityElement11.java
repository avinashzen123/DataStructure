package com.avinash.leetcode.medium;

import java.util.List;

/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * 
 * Input: nums = [3,2,3]
 * Output: [3]
 */
public class MajorityElement11 {

	/*
	 * There can be only one element appearing more than n/2 times
	 * There can be only two element appearing more than n/3 times
	 * There can be only three element appearing more than n/4 times.
	 */
	public static List<Integer> majorityElement(int[] nums) {
		Integer candidate1 = null;
		Integer candidate2 = null;
		Integer count1 = 0;
		Integer count2 = 0;
		for (int num : nums) {
			if (candidate1 != null && num == candidate1) {
				count1++;
			} else if (candidate2 != null && num == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1++;
			} else if (count2 == 0) {
				candidate2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		System.out.println(candidate1 + " " + count1);
		System.out.println(candidate2 + " " + count2);
		return List.of();
	}
	
	public static void main(String[] args) {
		majorityElement(new int[] {1, 2, 1, 2, 1, 3, 3, 3});
	}
}
