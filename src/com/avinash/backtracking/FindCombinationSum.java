package com.avinash.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindCombinationSum {
	
	public static List<ArrayList<Integer>> findCombinationSum(int[] array, int target) {
		List<ArrayList<Integer>> res = new ArrayList<>();
		dfs(res, array, target, 0, 0, new ArrayList<>());
		return res;
	}
	
	private static void dfs(List<ArrayList<Integer>> result, int[] array, int target, int currTotal, int currIndex, List<Integer> currSubset) {
		if (target == currTotal) {
			result.add(new ArrayList<>(currSubset));
			return;
		}
		if (target <= currTotal || currIndex >= array.length) {
			return;
		}
		
		currSubset.add(array[currIndex]);
		dfs(result, array, target, currTotal + array[currIndex], currIndex, currSubset);
		
		currSubset.remove(currSubset.size() - 1);
		dfs(result, array, target, currTotal, currIndex +1, currSubset);
	
	}
	
	public static void main(String[] args) {
		System.out.println(findCombinationSum(new int[] {2,3,6,7}, 7));
	}
}
