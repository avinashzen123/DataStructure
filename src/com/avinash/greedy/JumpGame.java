package com.avinash.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

	/*
	 * https://leetcode.com/problems/jump-game/ You are given an integer array nums.
	 * You are initially positioned at the array's first index, and each element in
	 * the array represents your maximum jump length at that position.
	 * 
	 * Return true if you can reach the last index, or false otherwise.
	 *
	 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
	 * to 1, then 3 steps to the last index.
	 * 
	 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive
	 * at index 3 no matter what. Its maximum jump length is 0, which makes it
	 * impossible to reach the last index.
	 * 
	 * 
	 */
	public static boolean canReachEnd(int[] jumps) {
		int goal = jumps[jumps.length - 1];
		for (int index = jumps.length - 1; index >= 0; index--) {
			if (index + jumps[index] >= goal) {
				goal = index;
			}
		}
		return goal == 0;
	}

	/*
	 * https://leetcode.com/problems/jump-game-ii/
	 * 
	 * You are given a 0-indexed array of integers nums of length n. You are
	 * initially positioned at nums[0].
	 * 
	 * Each element nums[i] represents the maximum length of a forward jump from
	 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
	 * j] where:
	 * 
	 * 1 <= j <= nums[i] and i + j < n Return the minimum number of jumps to reach
	 * nums[n - 1]. The test cases are generated such that you can reach nums[n -
	 * 1].
	 * 
	 * 
	 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
	 * to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
	 * the last index.
	 * 
	 * Input: nums = [2,3,0,1,4] Output: 2
	 * 
	 */
	public static int canReachEndMinSteps(int[] nums) {
		int result = 0;
		for (int left = 0, right = 0; right < nums.length - 1;) {
			int farthest = 0;
			for (int i = left; i <= right; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			left = right + 1;
			right = farthest;
			result++;
		}
		return result;
	}

	/*
	 * https://leetcode.com/problems/jump-game-iii/
	 * 
	 * Given an array of non-negative integers arr, you are initially positioned at
	 * start index of the array. When you are at index i, you can jump to i + arr[i]
	 * or i - arr[i], check if you can reach to any index with value 0.
	 * 
	 * Notice that you can not jump outside of the array at any time.
	 *
	 * Input: arr = [4,2,3,0,3,1,2], start = 5 Output: true Explanation: All
	 * possible ways to reach at index 3 with value 0 are: index 5 -> index 4 ->
	 * index 1 -> index 3 index 5 -> index 6 -> index 4 -> index 1 -> index 3
	 * 
	 * 
	 * Input: arr = [4,2,3,0,3,1,2], start = 0 Output: true Explanation: One
	 * possible way to reach at index 3 with value 0 is: index 0 -> index 4 -> index
	 * 1 -> index 3
	 * 
	 * 
	 */
	public static boolean canReach3(int[] arr, int start) {
		int[] visited = new int[arr.length];
		return canReach3(arr, start, visited);
	}

	private static boolean canReach3(int[] arr, int start, int[] visited) {
		if (start < 0 || start >= arr.length || visited[start] == 1) {
			return false;
		}
		if (arr[start] == 0) {
			return true;
		}
		visited[start] = 1;
		return canReach3(arr, start + arr[start], visited) || canReach3(arr, start - arr[start], visited);
	}

	/*
	 * https://leetcode.com/problems/jump-game-vii/ You are given a 0-indexed binary
	 * string s and two integers minJump and maxJump. In the beginning, you are
	 * standing at index 0, which is equal to '0'. You can move from index i to
	 * index j if the following conditions are fulfilled:
	 * 
	 * i + minJump <= j <= min(i + maxJump, s.length - 1), and s[j] == '0'. Return
	 * true if you can reach index s.length - 1 in s, or false otherwise.
	 * 
	 * Input: s = "011010", minJump = 2, maxJump = 3 Output: true Explanation: In
	 * the first step, move from index 0 to index 3. In the second step, move from
	 * index 3 to index 5.
	 * 
	 * Input: s = "01101110", minJump = 2, maxJump = 3 Output: false
	 * 
	 */
	public static boolean canReach4(String s, int minJump, int maxJump) {
		boolean [] visited = new boolean[s.length()];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while(!queue.isEmpty()) {
			Integer idx = queue.poll();
			if (idx == s.length() - 1) {
				return true;
			}
			for (int i = idx + minJump ; i <= idx + maxJump && i < s.length(); i++) {
				if (!visited[i] && s.charAt(i) == '0') {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] jumps = { 3, 2, 1, 0, 4 };
		System.out.println(canReachEnd(jumps));
		int[] jumps1 = { 2, 3, 1, 1, 4 };
		System.out.println(canReachEnd(jumps1));

//		System.out.println(canReachEndMinSteps(jumps));
		System.out.println(canReachEndMinSteps(jumps1));

		System.out.println(canReach3(new int[] { 4, 2, 3, 0, 3, 1, 2, 5 }, 0));
		System.out.println(canReach4("011010", 2, 3));
	}

}
