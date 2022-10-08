package com.avinash.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsUnique {

	public static List<ArrayList<Integer>> findUniqueSubsets(int[] array) {
		List<ArrayList<Integer>> result = new ArrayList<>();
		subsets(0, array, result, new ArrayList<>());
		return result;
	}

	private static void subsets(int currentIndex, int[] array, List<ArrayList<Integer>> result, List<Integer> subset) {
		result.add(new ArrayList<>(subset));
		for (int i = currentIndex; i < array.length; i++) {
			if (i > currentIndex && array[i] == array[i-1]) {
				continue;
			}
			subset.add(array[i]);
			subsets(i + 1, array, result, subset);
			subset.remove(subset.size() - 1);
		}
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 2 };
		System.out.println(findUniqueSubsets(array));
	}
}
