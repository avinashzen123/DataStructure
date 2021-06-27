package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;

public class MinSizeSubArray {
	public static void main(String[] args) {
		System.out.println(minSizeSubArray(new int[] {2, 1, -3, 4, 1}, 7));
	}
	
	public static List<Integer> minSizeSubArray(int[] array, int sum) {
		List<Integer> result = null;
		for (int i = 0; i< array.length; i++) {
			for (int j = i + 1 ; j < array.length ; j++) {
				List<Integer> subArrayWithSize = subArrayWithSize(array, array[i], j, sum);
				if (result == null || (subArrayWithSize != null && subArrayWithSize.size() < result.size())) {
					result = subArrayWithSize;
				}
			}
		}
		return result;
	}
	
	public static List<Integer> subArrayWithSize(int[] array, int prevValue, int start, int sum) {
		if (start < 0 || start >= array.length ) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		result.add(prevValue);
		sum -= prevValue;
		for (int i = start; i < array.length && sum > 0; i ++ ) {
			if (sum - array[i]  >= 0) {
				sum -= array[i];
				result.add(array[i]);
			}
		}
		
		if (sum == 0) {
			return result;
		}
		return null; 
	}
	
}
