package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindSum {
	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
//		System.out.println(Arrays.toString(numbers));
//		System.out.println(Arrays.toString(findTwoSum(numbers, target)));
//		Arrays.sort(numbers);
//		System.out.println(Arrays.toString(numbers));
//		System.out.println(Arrays.toString(findTwoSumSortedArray(numbers, target)));
//
//		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }, 0));
//		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
//
//		System.out.println(threeSum(new int[] { 0, 0, 0, 0 }, 0));
//
//		System.out.println(threeSum(new int[] { 1, -1, -1, 0 }, 0));
		
		System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(threeSum(new int[] {1,-1, -1, 0}));

	}

	/**
	 * Create a HashMap which will hold complement of one value in array 
	 * 
	 * Iterate over elements of an array
	 * 		First check if value is in map if yes there must a a value 
	 * 		in array if we sum those it will be equal to sum
	 * 
	 * 		if not put complement in map map.put(sum - array[i], index)
	 * 
	 * @param array : Unsorted array of integer
	 * @param sum : Required sum to be equal sum of two elements.
	 * @return : Index of two elelement whose sum is equal to sum
	 */
	public static int[] findTwoSum(int[] array, int sum) {
		Map<Integer, Integer> complementMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer complementIndex = complementMap.get(array[i]);
			if (complementIndex != null) {
				return new int[] { complementIndex, i };
			}
			complementMap.put(sum - array[i], i);
		}
		return null;
	}

	/**
	 * Because array is sorted we can use sliding window technique.
	 * Start one variable from start while other variable from end. 
	 * Will iterate over till start < end
	 * every iteration find sum of those index
	 * 		If current sum is less than required sum we will increase start by
	 * 		1, because we need to increase value
	 * 
	 * 		if current sum is more than required sum we will decrease end by 
	 * 		1, because we need to decrease value. 
	 * 
	 *  
	 * @param array : Sorted array
	 * @param sum : Required sum to be equal sum of two elements.
	 * @return : Index of two elelement whose sum is equal to sum
	 */
	public static int[] findTwoSumSortedArray(int[] array, int sum) {
		if (array == null || array.length < 1)
			return null;
		int low = 0, high = array.length - 1;
		while (low < high) {
			int currentSum = array[low] + array[high];
			if (currentSum < sum) {
				low++;
			} else if (currentSum > sum) {
				high--;
			} else {
				return new int[] { low, high };
			}
		}
		return null;
	}

	// Find all unique triplets which give the sum of zero
	/**
	 * We need to start two loops
	 * 
	 * i start with 0 till length - 2
	 * every iteration check if array[i] != array[i-1] in such case we had 
	 * 		already computed sum
	 * 
	 * otherwise start sliding window low = i + 1 and high = array.length - 1
	 * iterate till low < high
	 * 		in every iteration compute sum if sum is found add it to result
	 * 		then find out next different value from start and end
	 * 
	 * 		if currentSum > sum reduce end by 1
	 * 		if currentSum < sum increase start by 1
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int low = i + 1;
				int high = num.length - 1;
				int sum = target - num[i];
				while (low < high) {
					if (num[low] + num[high] == sum) {
						result.add(List.of(num[i], num[low], num[high]));
						while (low < high && num[low] == num[low + 1])
							low++;
						while (low < high && num[high] == num[high - 1])
							high--;
						low++;
						high--;
					} else if (num[low] + num[high] > sum) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        for (int left = 0; left < nums.length - 2; left++) {
//            int mid = left + 1;
//            int right = nums.length - 1;
//            int remainingSum = -nums[left];
//            while(mid < right) {
//                int currSum = nums[mid] + nums[right];
//                if (currSum == remainingSum) {
//                    result.add(List.of(nums[left], nums[mid], nums[right]));
//                    while (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) mid++;
//                    while (right > 0 && nums[right] == nums[right - 1]) right--;
////                    while(left < nums.length - 2 && nums[left] == nums[left + 1]) left++;
//                    mid++;
//                    right--;
//                } else if (currSum < remainingSum ) {
//                	right--;
//                } else {
//                	mid++;
//                }
//            }
//            
//        }
//        return result;
		
		int target = 0;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first == 0 || (first > 0 && nums[first] != nums[first - 1])) {
                int need = target - nums[first] ;
                int low = first + 1;
                int end = nums.length - 1;
                while (low < end) {
                    int remaining = nums[low] + nums[end];
                    if (remaining  == need) {
                        result.add(List.of(nums[first], nums[low], nums[end]));
                        while(low < end && nums[low] == nums[low + 1]) low++;
                        while(low < end && nums[end] == nums[end-1]) end--;
                        low ++;
                        end--;
                    } else if (remaining > need) {
                        end --;
                    } else {
                        low ++;
                    }
                }
            }
        }
        return result;
    }
	
	public static int threeSumClosest(int[] numbers, int target) {
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(numbers);

		for (int first = 0; first < numbers.length; first++) {
			int remaining = target - numbers[first];
			int low = first + 1;
			int high = numbers.length - 1;

			while (low < high) {
				int currentSum = numbers[low] + numbers[high];
				if (currentSum == remaining) {
					minDiff = 0;
					while (low < high && numbers[low] == numbers[low + 1])
						low++;
					while (low < high && numbers[high] == numbers[high - 1])
						high--;
				} else if (currentSum < remaining) {
					low++;
//					if (target - (numbers[first] + numbers[low] + numbers))
				}	
			}
		}

		return -1;
	}

	/**
	 * Finding three sum is sub problem of this.
	 * We need to start total three loop
	 * first two variable firsIndex starts with zero till length - 2 and 
	 * 		secondIndex start with firstIndex + 1 till length - 1
	 * 
	 * 		Start sliding window check 
	 * 		find and compare sum as we do in three sum problem
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] numbers, int target) {
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		List<List<Integer>> result = new ArrayList<>();
		for (int firstIndex = 0; firstIndex < numbers.length - 2; firstIndex++) {
			for (int secondIndex = firstIndex + 1; secondIndex < numbers.length - 1; secondIndex++) {
				int low = secondIndex + 1;
				int high = numbers.length - 1;
				while (low < high) {
					Integer currentSum = numbers[low] + numbers[high] + numbers[firstIndex] + numbers[secondIndex];
					if (currentSum == target) {
						result.add(
								Arrays.asList(numbers[firstIndex], numbers[secondIndex], numbers[low], numbers[high]));
						while (low < high && numbers[low] == numbers[low + 1])
							low++;
						while (low < high && numbers[high] == numbers[high - 1])
							high--;
						low++;
						high--;
					} else if (currentSum > target) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return result;
	}
}
