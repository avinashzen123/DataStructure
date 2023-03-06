package com.avinash.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/random-pick-with-weight/editorial/
 *
 */
public class RandomPickWithWeight {
	private int[] prefixSum;
	private int totalWeight;
	private int[] weights;
	public RandomPickWithWeight(int[] w) {
		this.prefixSum = new int[w.length];
		this.weights = w;
		for (int i = 0; i < w.length; i++) {
			totalWeight += w[i];
			prefixSum[i] = this.totalWeight;
		}
		System.out.println(Arrays.toString(this.prefixSum));
	}

	public int pickIndex() {
		double targetIndex = this.totalWeight * Math.random();
		int low = 0;
		int high = this.prefixSum.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (targetIndex > prefixSum[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		RandomPickWithWeight pickWithWeight = new RandomPickWithWeight(new int[] {1, 3});
		System.out.println(pickWithWeight.pickIndex());
		System.out.println(pickWithWeight.pickIndex());
		System.out.println(pickWithWeight.pickIndex());	
	}
}
