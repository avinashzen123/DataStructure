package com.avinash.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSumInArray {
	public static void main(String[] args) {
		System.out.println(findArray(new int[] { 2, 1, -3, 4, 1 }, 7));
	}

	public static int[] findArray(int[] array, final int k) {
		Map<Integer, List<Integer>> subMap = new HashMap<>();
		for (int j : array) {
			int sub = k - j;
			if (!subMap.containsKey(sub)) {
				subMap.put(sub, new ArrayList<>());
			}
			subMap.get(sub).add(j);
		}
		for (int i = 0; i < array.length - 1; i++) {
			List<Integer> res = new ArrayList<>();
			res.add(i);
			int remainingSum = k - array[i];
			for (int j = 0; j < array.length && remainingSum != 0; j++) {
				
			}
		}
		System.out.println(subMap);
		return new int[] { 1 };
	}
}
