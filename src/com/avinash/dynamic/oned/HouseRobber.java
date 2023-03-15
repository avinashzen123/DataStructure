package com.avinash.dynamic.oned;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
	// https://leetcode.com/problems/house-robber/
	/*
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping you
	 * from robbing each of them is that adjacent houses have security systems
	 * connected and it will automatically contact the police if two adjacent houses
	 * were broken into on the same night.
	 * 
	 * Given an integer array nums representing the amount of money of each house,
	 * return the maximum amount of money you can rob tonight without alerting the
	 * police.
	 * 
	 * 
	 * Input: nums = [1,2,3,1]
	 * 
	 * 
	 * Output: 4
	 * 
	 * 
	 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total
	 * amount you can rob = 1 + 3 = 4.
	 * 
	 * 
	 */
	public static int rob(int[] nums) {
		int robWithoutIncludingLastHouse = 0;
		int robWithIncludingLastHouse = 0;
		for (int num : nums) {
			int temp = Math.max(num + robWithoutIncludingLastHouse, robWithIncludingLastHouse);
			robWithoutIncludingLastHouse = robWithIncludingLastHouse;
			robWithIncludingLastHouse = temp;
		}
		return robWithIncludingLastHouse;
	}

	public static int robDp(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.min(nums[0], nums[1]);
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

	/*
	 * https://leetcode.com/problems/house-robber-ii/
	 * 
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed. All houses at this place are
	 * arranged in a circle. That means the first house is the neighbour of the last
	 * one. Meanwhile, adjacent houses have a security system connected, and it will
	 * automatically contact the police if two adjacent houses were broken into on
	 * the same night.
	 * 
	 * Given an integer array nums representing the amount of money of each house,
	 * return the maximum amount of money you can rob tonight without alerting the
	 * police
	 * 
	 * Input: nums = [1,2,3,1]
	 * 
	 * 
	 * Output: 4
	 * 
	 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total
	 * amount you can rob = 1 + 3 = 4.
	 * 
	 */
	public static int rob2(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob2Helper(nums, 0, nums.length - 1), rob2Helper(nums, 1, nums.length));
	}

	private static int rob2Helper(int[] nums, int start, int end) {
		int robHouseWithIncludingLastHoue = 0;
		int robHouseWithoutIncludingLastHouse = 0;
		for (int i = start; i < end; i++) {
			int temp = Math.max(robHouseWithoutIncludingLastHouse + nums[i], robHouseWithIncludingLastHoue);
			robHouseWithoutIncludingLastHouse = robHouseWithIncludingLastHoue;
			robHouseWithIncludingLastHoue = temp;
		}
		return robHouseWithIncludingLastHoue;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	/*
	 * https://leetcode.com/problems/house-robber-iii/
	 * 
	 * The thief has found himself a new place for his thievery again. There is only
	 * one entrance to this area, called root.
	 * 
	 * Besides the root, each house has one and only one parent house. After a tour,
	 * the smart thief realized that all houses in this place form a binary tree. It
	 * will automatically contact the police if two directly-linked houses were
	 * broken into on the same night.
	 * 
	 * Given the root of the binary tree, return the maximum amount of money the
	 * thief can rob without alerting the police
	 * 
	 * 
	 * Input: root = [3,2,3,null,3,null,1] Output: 7 Explanation: Maximum amount of
	 * money the thief can rob = 3 + 3 + 1 = 7.
	 * 
	 */
	
	
	public int rob(TreeNode root) {
        // if (root == null) return 0;
        // int ans = 0;
        // if (root.left != null) {
        //     ans += rob(root.left.left) + rob(root.left.right);
        // }
        // if (root.right != null) {
        //     ans+= rob(root.right.left) + rob(root.right.right);
        // }
        // return Math.max(ans + root.val, rob(root.left) + rob(root.right));
        return rob(root, new HashMap<>());
    }
    private int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int ans = 0;
        if (root.left != null) {
            ans += rob(root.left.right) + rob(root.left.left);
        }
        if (root.right != null) {
            ans += rob(root.right.left) + rob(root.right.right);
        }
        ans = Math.max(ans + root.val, rob(root.left) + rob(root.right));
        map.put(root, ans);
        return ans;
    }

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(robDp(new int[] { 1, 2, 3, 1 }));

		System.out.println(rob2(new int[] { 1, 2, 3, 1 }));
	}
}
