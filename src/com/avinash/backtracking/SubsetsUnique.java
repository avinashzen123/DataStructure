package com.avinash.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsUnique {

	public static List<ArrayList<Integer>> findUniqueSubsets(int[] array) {
		List<ArrayList<Integer>> result = new ArrayList<>();
		dfs(0, array, result, new ArrayList<>());
		return result;
	}
	
	private static void dfs(int currentIndex, int[] array, List<ArrayList<Integer>> result, List<Integer> subset) {
		if (currentIndex >= array.length) {
			result.add(new ArrayList<Integer>(subset));
		} else {
			subset.add(array[currentIndex]);
			dfs(currentIndex + 1, array, result, subset);
			subset.remove(subset.size() - 1);
			dfs(currentIndex+1, array, result, subset);
		}
	}

	public static void main(String[] args) {
		int array[] = {1,2,3};
		System.out.println(findUniqueSubsets(array));
	}
}
