package com.avinash.interview;

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

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1, 2, 3, 4 };
		int majority = findMajorityElement(arr);
		System.out.println("The majority element is : " + majority);
	}
}
