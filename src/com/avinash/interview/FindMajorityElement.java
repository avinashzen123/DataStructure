package com.avinash.interview;

import java.util.Arrays;

// https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
public class FindMajorityElement {

	public static int findMajorityElement(int[] nums) {
		int count = 0;
		int candidate = -1;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
				count++;
			} else {
				if (num == candidate) {
					count++;
				} else {
					count--;
				}
			}
		}
		count = 0;
		for (int num : nums) {
			if (candidate == num)
				count++;
		}
		if (count > nums.length / 2)
			return candidate;
		return -1;
	}
	
	//https://leetcode.com/problems/majority-element-ii/
	/**
	 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times
	 * 
	 * https://www.youtube.com/watch?v=yDbkQd9t2ig
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] findTwoMojorityElement (int[] nums) {
		int num1 = -1, num2 = -1, num1Count = 0, num2Count = 0;
		
		for (int num: nums) {
			if (num == num1) num1Count++;
			else if (num == num2) num2Count++;
			else if (num1Count == 0) {
				num1 = num;
				num1Count = 1;
			} else  if (num2Count == 0) {
				num2 = num;
				num2Count = 1;
			} else {
				num1Count --;
				num2Count --;
			}
		}
		num1Count = 0;
		num2Count = 0;
		for (int num : nums) {
			if (num == num1) num1Count ++;
			else if (num == num2) num2Count ++;
		}
		if (num1Count >= nums.length / 3 && num2Count >= nums.length/3) {
			return new int[] {num1, num2};
		}
		return new int[] {-1, -1};
	}
	
	public static int[] findAllMojorityElement (int[] nums) {
		int[] majorityEl = {-1, -1, -1};
		int[] mojorityCount = {0,0,0};
		for (int num : nums) {
			if (num == majorityEl[0]) mojorityCount[0]++;
			else if (num == majorityEl[1]) mojorityCount[1]++;
			else if (num == majorityEl[2]) mojorityCount[2]++;
			else if (mojorityCount[0] == 0) {
				mojorityCount[0] ++;
				majorityEl[0] = num;
			} else if (mojorityCount[1] == 0) {
				mojorityCount[1] ++;
				majorityEl[1] = num;
			} else if (mojorityCount[2] == 0) {
				mojorityCount[2] ++;
				majorityEl[2] = num;
			} else {
				mojorityCount[0] --;
				mojorityCount[1] --;
				mojorityCount[2] --;
			}
		}
		return majorityEl;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1, 2, 3, 4 };
		int majority = findMajorityElement(arr);
		System.out.println("The majority element is : " + majority);
		System.out.println(Arrays.toString(findTwoMojorityElement(new int[] {1,1,2,3,3,3,1,2, 2, 2})));
		System.out.println(Arrays.toString(findAllMojorityElement(new int[] {1,1,2,3,3,3,1,2, 2, 2})));
	}
}
