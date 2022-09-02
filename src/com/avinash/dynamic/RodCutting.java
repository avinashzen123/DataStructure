package com.avinash.dynamic;

public class RodCutting {
	private int rodLength;
	private int[][] dpTable;
	private int[] prices;

	public RodCutting(int rodLength, int[] prices) {
		this.rodLength = rodLength;
		this.prices = prices;
		this.dpTable = new int[rodLength + 1][rodLength + 1];
	}
	
	
	
	public void solve() {
		for (int priceIndex = 1; priceIndex < prices.length; priceIndex++) {
			for (int len = 1; len < rodLength + 1; len++) {
				if (priceIndex <= len) {
					dpTable[priceIndex][len] = Math.max(dpTable[priceIndex-1][len], prices[priceIndex] + dpTable[priceIndex][len-priceIndex]);
				} else {
					dpTable[priceIndex][len] = dpTable[priceIndex-1][len];
				}
			}
		}
	}
	
	public void show() {
		System.out.println("Optimal profit : $ " + dpTable[prices.length - 1][rodLength]);
		for (int rowIndex = prices.length - 1, colIndex = rodLength; rowIndex > 0; ) {
			if (dpTable[rowIndex][colIndex] != 9 && dpTable[rowIndex][colIndex] != dpTable[rowIndex-1][colIndex]) {
				System.out.println("We use price : " + rowIndex + "m");
				colIndex = colIndex - rowIndex;
			} else {
				rowIndex--;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] prices = {0, 2, 5, 7, 3, 9};
		
		RodCutting cutting = new RodCutting(n, prices);
		cutting.solve();
		cutting.show();
		
	}
}
