package com.avinash.dynamic;

// https://leetcode.com/problems/n-th-tribonacci-number/description/
public class Tribonacci {

	public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
        }
        return nums[n];
    }
}
