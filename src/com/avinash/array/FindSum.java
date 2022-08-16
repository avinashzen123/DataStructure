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
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(findTwoSum(numbers, target)));
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(findTwoSumSortedArray(numbers, target)));

		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }, 0));
		System.out.println(fourSum(new int[] {1, 0, -1, 0, -2, 2} , 0));
		
	}

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

	public static int threeSumClosest(int[] numbers, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		
		return result;
	}
	
	
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
						result.add(Arrays.asList(numbers[firstIndex], numbers[secondIndex], numbers[low], numbers[high]));
						while(low < high && numbers[low] == numbers[low + 1]) low++;
						while(low < high && numbers[high] == numbers[high - 1]) high--;
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
