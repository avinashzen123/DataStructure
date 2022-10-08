package com.avinash.array;

public class MaxConsecutiveOneByFlipping0s {
    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int countZero = 0;
        for (int right = 0; right < nums.length; right++) {
        	if (nums[right] == 0 ) countZero++;
        	if (nums[right] == 1) {
			}
        	while (countZero > k) {
        		if (nums[left] == 0) {
        			countZero--;
        		} 
        		left++;
        	}
        	result = Math.max(result, right - left + 1);
        }
    	return result;
    }
    
    public static void main(String[] args) {
		System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
		System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
	}
}
