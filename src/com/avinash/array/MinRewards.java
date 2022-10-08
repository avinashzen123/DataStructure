package com.avinash.array;

import java.util.Arrays;

public class MinRewards {

	public static int minRewardsBruteForce(int[] scores) {
		// Write your code here.
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		for (int i = 1; i < scores.length; i++) {
			int j = i - 1;
			if (scores[i] > scores[j]) {
				rewards[i] = rewards[j] + 1;
			} else {
				while (j >= 0 && scores[j] > scores[j + 1]) {
					rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
					j--;
				}
			}
		}
		int result = 0;
		for (int r : rewards) {
			result += r;
		}
		return result;
	}

	public static int minRewards(int[] scores) {
		int result = 0;
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		for (int i = 1; i < scores.length - 1; i++) {
			if (scores[i] > scores[i - 1]) {
				rewards[i] = rewards[i - 1] + 1;
			}
		}
		for (int i = scores.length - 2; i >= 0; i--) {
			if (scores[i] > scores[i + 1]) {
				rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
			}
		}
		for (int r : rewards) {
			result += r;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(minRewardsBruteForce(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 }));
		System.out.println(minRewards(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 }));
	}
}
