package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
// https://www.geeksforgeeks.org/subset-sum-problem-osum-space/?ref=rp
class SubSetSumRecursive {
	/*
	 * Therefore time complexity of the above solution is exponential. The problem
	 * is in-fact NP-Complete (There is no known polynomial time solution for this
	 * problem).
	 */
	private static boolean isSubsetSum(int[] array, int index, int sum) {
		if (sum < 0)
			return false;
		if (sum == 0)
			return true;
		if (index < 0)
			return false;
		if (array[index] > sum)
			return isSubsetSum(array, index - 1, sum);
		return isSubsetSum(array, index - 1, sum) || isSubsetSum(array, index - 1, sum - array[index]);
	}

	public static boolean isSubsetSum(int[] array, int sum) {
		return isSubsetSum(array, array.length - 1, sum);
	}
}

class SubSetSumTabulation {

	/*
	 * if (A[i-1] > j) DP[i][j] = DP[i-1][j] else DP[i][j] = DP[i-1][j] OR
	 * DP[i-1][j-A[i-1]]
	 * 
	 * set[]={3, 4, 5, 2} target=6
	 * 
	 * 	 0 1 2 3 4 5 6
	 * 
	 * 0 T F F F F F F
	 * 
	 * 3 T F F T F F F
	 * 
	 * 4 T F F T T F F
	 * 
	 * 5 T F F T T T F
	 * 
	 * 2 T F T T T T T	
	 */
	public static boolean isSubsetSum(int[] array, int sum) {
		int length = array.length;
		boolean[][] subset = new boolean[sum + 1][length + 1];
		// if sum is 0 the answer it is true
		IntStream.range(0, length + 1).forEach(i -> subset[0][i] = true);
		// if sum is not zero and array is empty the false
		IntStream.range(0, sum + 1).forEach(i -> subset[i][0] = false);

		for (int curSum = 1; curSum <= sum; curSum++) {
			System.out.println("--------------");
			Arrays.stream(subset).map(Arrays::toString).forEach(System.out::println);
			for (int curValIndex = 1; curValIndex <= length; curValIndex++) {
				subset[curSum][curValIndex] = subset[curSum][curValIndex - 1];
				if (curSum >= array[curValIndex - 1]) {
					int raminingSum = curSum - array[curValIndex - 1];
					subset[curSum][curValIndex] = subset[curSum][curValIndex]
							|| subset[raminingSum][curValIndex - 1];
				}
			}
		}
		return subset[sum][length];
	}
}

/*
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True There is a subset
 * (4, 5) with sum 9.
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30 Output: False There is no
 * subset that add up to 30.
 */
public class SubSetSum {
	public static void main(String[] args) {
		System.out.println(SubSetSumRecursive.isSubsetSum(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
//		System.out.println(SubSetSumTabulation.isSubsetSum(new int[] { 3, 34, 4, 12, 5, 2 }, 9));
		System.out.println(SubSetSumTabulation.isSubsetSum(new int[] { 3, 4, 5, 2 }, 6));
	}
}
