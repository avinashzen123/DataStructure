package com.avinash.array;

public class MaximumSubArray_Kadane {
	//https://www.youtube.com/watch?v=5WZl3MMT0Eg
	
	//O(n)linear time complexity
	public int kadaneAlgorithm(int[] nums) {
//		int globalMax = nums[0];
//		int localMax = nums[0];
//		
//		for (int i = 1; i < nums.length; i++) {
//			localMax = Math.max(nums[i], localMax + nums[i]);
//			globalMax = Math.max(globalMax, localMax);
////			if (localMax > globalMax) {
////				globalMax = localMax;
////			}
//		}
//		return globalMax;
		int curMax = nums[0];
	    int max =  nums[0];
	    for(int num : nums) {
	      curMax = Math.max(num, num + curMax);
	      max = Math.max(max, curMax);
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] n = {1,-2,3,4};
		n = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubArray_Kadane algorithm = new MaximumSubArray_Kadane();
		System.out.println(algorithm.kadaneAlgorithm(n));
		System.out.println(algorithm.kadaneAlgorithm(new int[] {100, 8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6, 20, -23, 15, 1, -3, 4}));
	}
}
