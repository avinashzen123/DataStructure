package com.avinash.dynamic;

// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
class RecursiveWayCounting {
	/*
	 * TIme complexity O(n ^ 2)
	 */
	public static int countNumberOfWays(int stairs, int steps) {
		if (stairs <= 1)
			return stairs;
		int res = 0;
		for (int i = 1; i <= stairs && i <= steps; i++) {
			res += countNumberOfWays(stairs - i, steps);
		}
		return res;
	}
}

class DynamciProgramming {

	/*
	 * We create a table res[] in bottom up manner using the following relation:
	 * 
	 * res[i] = res[i] + res[i-j] for every (i-j) >= 0
	 * 
	 * such that the ith index of the array will contain the number of ways required
	 * to reach the ith step considering all the possibilities of climbing (i.e.
	 * from 1 to i).
	 */
	public static int countNumberOfWays(int stairs, int steps) {
		int res[] = new int[stairs+ 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= stairs; i++) {
			res[i] = 0;
			for (int j = 1; j <= steps; j++) {
				res[i] += res[i - j];
			}
		}
		return res[stairs];
	}
	
	public static int countNumberOfWaysTwoStep(int stairs) {
		int prev1 = 1;
		int prev2 = 1;
		for (int i = 2; i <= stairs; i++ ) {
			int cur = prev1 + prev2;
			prev2 = prev1;
			prev1 = cur;
		}
		return prev1;
	}
}

public class NumberOfWaysToClimbStairs {
    
    public static void main(String[] args) {
        int stairs = 5;
		int steps = 2;
		System.out.println(RecursiveWayCounting.countNumberOfWays(stairs + 1, steps));
		System.out.println(DynamciProgramming.countNumberOfWays(stairs , steps));
		System.out.println(DynamciProgramming.countNumberOfWaysTwoStep(stairs));
    }
}
