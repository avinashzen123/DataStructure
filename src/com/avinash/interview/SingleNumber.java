package com.avinash.interview;

public class SingleNumber {
    // https://leetcode.com/problems/single-number/
    /**
     * Every element appears twice except for one find that element
     * 
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * https://leetcode.com/problems/single-number-ii/
     * https://www.youtube.com/watch?v=cOFAmaMBVps
     * 
     * Given an integer array nums where every element appears three times except
     * for one, which appears exactly once. Find the single element and return it.
     * 
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     * 
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = one ^ num & (~two);
            two = two ^ num & (~one);
        }
        return one;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
        System.out.println(singleNumber2(new int[] { 4, 1, 1, 2, 1, 2, 2 }));
        System.out.println(singleNumber2(new int[] { 2,2,2,3}));
    }
}
