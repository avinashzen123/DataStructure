package com.avinash.array;

public class MaxPointFromCard {

	public static int maxScore(int[] cardPoints, int k) {
		int left = -1; 
		int right = cardPoints.length - k;
		int max = Integer.MIN_VALUE;
		while (right < cardPoints.length) {
			int leftSum = 0;
			for (int i = left; i >= 0; i--) {
				leftSum += cardPoints[i];
			}
			int rightSum = 0;
			for (int i = right; i < cardPoints.length; i++) {
				rightSum += cardPoints[i];
			}
			max = Math.max(max, rightSum + leftSum);
			left++;
			right++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
	}
	
}
