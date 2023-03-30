package com.avinash.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/random-pick-index/description/
/**
 * Given an integer array nums with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Implement the Solution class:
 * 
 * Solution(int[] nums) Initializes the object with the array nums. int pick(int
 * target) Picks a random index i from nums where nums[i] == target. If there
 * are multiple valid i's, then each index should have an equal probability of
 * returning.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input ["Solution", "pick", "pick", "pick"] [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * Output [null, 4, 0, 2]
 * 
 * Explanation Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each
 * index should have equal probability of returning. solution.pick(1); // It
 * should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each
 * index should have equal probability of returning.
 * 
 * @author avinashsharma
 *
 */
public class RandomPickElement {
	static class BruteForce {
		private int[] nums;
		private Random random;

		public BruteForce(int[] nums) {
			this.nums = nums;
			this.random = new Random();
		}

		// Time Complexity : O(N)
		// Space complexity : O(n)
		public int pick(int target) {
			List<Integer> indices = new ArrayList<>();
			int n = this.nums.length;
			for (int i = 0; i < n; i++) {
				if (this.nums[i] == target) {
					indices.add(i);
				}
			}
			int l = indices.size();
			int randomIndex = indices.get(random.nextInt(l));
			return randomIndex;
		}
	}

	static class UsingHashMapCache {
		private HashMap<Integer, List<Integer>> indices;
		private Random rand;

		public UsingHashMapCache(int[] nums) {
			this.rand = new Random();
			this.indices = new HashMap<>();
			int l = nums.length;
			for (int i = 0; i < l; i++) {
				if (!this.indices.containsKey(nums[i])) {
					this.indices.put(nums[i], new ArrayList<>());
				}
				this.indices.get(nums[i]).add(i);
			}
		}

		public int pick(int target) {
			int l = indices.get(target).size();
			int randomIndex = indices.get(target).get(rand.nextInt(l));
			return randomIndex;
		}
	}
}
