package com.avinash.dynamic;

import java.util.Stack;

// https://youtu.be/ZI2z5pq0TqA
public class TrappingRainWater {

	static class BruteForce {
		// Time complexity : O(n ^ 2)
		static int solve(int[] heights) {
			int ans = 0;
			int size = heights.length;
			for (int i = 1; i < size - 1; i++) {
				int leftMax = 0;
				int rightMax = 0;
				for (int j = i; j >= 0; j--) {
					leftMax = Math.max(leftMax, heights[j]);
				}
				for (int j = i; j < size; j++) {
					rightMax = Math.max(rightMax, heights[j]);
				}
				ans += Math.min(leftMax, rightMax) - heights[i];
			}
			return ans;
		}
	}

	static class DynamicProgaramming {
		// Time complexity : O(n)
		static int solve(int[] heights) {
			// Less than 3 we can
			if (heights.length < 3)
				return 0;

			int[] leftMax = new int[heights.length];
			int[] rightMax = new int[heights.length];
			leftMax[0] = 0;
			for (int i = 1; i < leftMax.length; i++) {
				leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);
			}
			rightMax[rightMax.length - 1] = 0;
			for (int i = rightMax.length - 2; i >= 0; i--) {
				rightMax[i] = Math.max(rightMax[i + 1], heights[i + 1]);
			}
			int trapped = 0;
			for (int i = 0; i < heights.length; i++) {
				if (Math.min(leftMax[i], rightMax[i]) > heights[i]) {
					trapped += Math.min(leftMax[i], rightMax[i]) - heights[i];
				}
			}
			return trapped;
		}
	}

	static class TwoPointer {
		static int solve(int[] heights) {
			int left = 0;
			int right = heights.length - 1;
			int leftMax = 0;
			int rightMax = 0;
			int ans = 0;
			while (left < right) {
				if (heights[left] < heights[right]) {
					if (heights[left] > leftMax)
						leftMax = heights[left];
					else
						ans += (leftMax - heights[left]);
					left++;
				} else {
					if (heights[right] > rightMax) {
						right = heights[right];
					} else {
						ans += (rightMax - heights[right]);
					}
					right--;
				}
			}
			return ans;
		}
	}

	/**
	 * Each time I come across a bar, pop all previous bar that is no greater than
	 * it as well as sum up water trapped. And then, when the peek bar of stack is
	 * greater than it, calculate water trapped against that bar.
	 * 
	 */
	static class UsingStack {
		static int solve(int[] heights) {
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			int pre = 0;
			int i = -1;
			while (++i < heights.length) {
				if (heights[i] == 0) {
					pre = 0;
					continue;
				}
				while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
					int lastIndex = stack.pop();
					sum += (heights[lastIndex] - pre) * (i - lastIndex - 1);
					pre = heights[lastIndex];
				}
				if (!stack.isEmpty()) {
					sum += (heights[i] - pre) * (i - stack.peek() - 1);
					pre = heights[i];
				}
				stack.push(i);
			}
			return sum;
		}
	}

	public static void main(String[] args) {
//		int[] heights = {2,1,3,1,4};
		int[] heights = { 4, 1, 3, 1, 5 };
		System.out.println(DynamicProgaramming.solve(heights));
		System.out.println(BruteForce.solve(heights));
		System.out.println(TwoPointer.solve(heights));
		System.out.println(UsingStack.solve(heights));
	}
}
