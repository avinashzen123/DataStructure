package com.avinash.dynamic;

public class MaximumSubArray_Kadane {
	
	//O(n)linear time complexity
	public int kadaneAlgorithm(int[] nums) {
		int globalMax = nums[0];
		int localMax = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			localMax = Math.max(nums[i], localMax + nums[i]);
			if (localMax > globalMax) {
				globalMax = localMax;
			}
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		int[] n = {1,-2,3,4};
		MaximumSubArray_Kadane algorithm = new MaximumSubArray_Kadane();
		System.out.println(algorithm.kadaneAlgorithm(n));
	}
}
