package com.avinash.dynamic;

/*
 * Time Complexity: O(n2)
 * Auxiliary Space: O(n2)+O(n) 
 */
//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
class RodCuttingRecursive {
	public static int count;

	private static int cutRod(int[] prices, int length, int remainingLength) {
		count++;
		if (length == 0)
			return prices[length] * remainingLength;

		int notCut = cutRod(prices, length - 1, remainingLength);
		int cut = Integer.MIN_VALUE;

		if (length + 1 <= remainingLength) {
			cut = prices[length] + cutRod(prices, length, remainingLength - (length + 1));
		}
		return Math.max(cut, notCut);
	}

	public static int cutRod(int[] prices) {
		return cutRod(prices, prices.length - 1, prices.length);
	}
}

class RodCuttingTabuation {
	private int rodLength;
	private int[][] dpTable;
	private int[] prices;

	public RodCuttingTabuation(int rodLength, int[] prices) {
		this.rodLength = rodLength;
		this.prices = prices;
		this.dpTable = new int[rodLength + 1][rodLength + 1];
	}

	public void solve() {
		for (int priceIndex = 1; priceIndex < prices.length; priceIndex++) {
			for (int len = 1; len < rodLength + 1; len++) {
				if (priceIndex <= len) {
					dpTable[priceIndex][len] = Math.max(dpTable[priceIndex - 1][len],
							prices[priceIndex] + dpTable[priceIndex][len - priceIndex]);
				} else {
					dpTable[priceIndex][len] = dpTable[priceIndex - 1][len];
				}
			}
		}
	}

	public void show() {
		System.out.println("Optimal profit : $ " + dpTable[prices.length - 1][rodLength]);
		for (int rowIndex = prices.length - 1, colIndex = rodLength; rowIndex > 0;) {
			if (dpTable[rowIndex][colIndex] != 9 && dpTable[rowIndex][colIndex] != dpTable[rowIndex - 1][colIndex]) {
				System.out.println("We use price : " + rowIndex + "m");
				colIndex = colIndex - rowIndex;
			} else {
				rowIndex--;
			}
		}
	}
}

public class RodCutting {

	public static void main(String[] args) {
		int n = 5;
		int[] prices = { 0, 2, 5, 7, 3, 9 };

		RodCuttingTabuation cutting = new RodCuttingTabuation(n, prices);
		cutting.solve();
		cutting.show();

		int cutRod = RodCuttingRecursive.cutRod(prices);
		System.out.println(cutRod);
		System.out.println(RodCuttingRecursive.count);

		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		cutRod = RodCuttingRecursive.cutRod(arr);
		System.out.println(cutRod);

	}
}
