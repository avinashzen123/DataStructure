package com.avinash.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a
 * list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 *
 * Input: k = 3, n = 7 Output: [[1,2,4]] Explanation: 1 + 2 + 4 = 7 There are no
 * other valid combinations.
 * 
 */
public class CombinationSum {
	protected void backTrack(int remain, int k, LinkedList<Integer> comb, int nextStart, List<List<Integer>> results) {
		if (remain == 0 && comb.size() == k) {
			results.add(new ArrayList<>(comb));
		} else if (remain < 0 || comb.size() == k) {
			return;
		}
		for (int i = nextStart; i < 9; i++) {
			comb.add(i + 1);
			backTrack(remain - i - 1, k, comb, i + 1, results);
			comb.removeLast();
		}
	}

	/**
	 * 
	 * Time Complexity : O(9! k / (9-k)!)
	 * 
	 * In a worst scenario, we have to explore all potential combinations to the
	 * very end, i.e. the sum nnn is a large number (n>9∗9). At the first step, we
	 * have 999 choices, while at the second step, we have 8 choices, so on and so
	 * forth.
	 * 
	 * The number of exploration we need to make in the worst case would be
	 * P(9,K)=9!(9−K)! , assuming that K<=9. By the way, K cannot be greater than 9,
	 * otherwise we cannot have a combination whose digits are all unique.
	 * 
	 * Each exploration takes a constant time to process, except the last step where
	 * it takes O(K) time to make a copy of combination.
	 * 
	 * 
	 * To sum up, the overall time complexity of the algorithm would be
	 * 9!/(9−K)! . ⋅O(K)=O( 9!⋅K / (9−K)!  ​ ).
	 * 
	 * 
	 * 
	 */
	public List<List<Integer>> combinationSum(int k, int n) {
		List<List<Integer>> results = new ArrayList<>();
		LinkedList<Integer> comb = new LinkedList<>();
		backTrack(n, k, comb, 0, results);
		return results;
	}

	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(3, 9));
	}
}
