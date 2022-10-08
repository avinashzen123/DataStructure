package com.avinash.sliding.window;

public class BestTimeToBuySellStock {
	
	public static int maxProfilt(int[] prices) {
		int left = 0;
		int maxProfit = 0;
		for (int right = 0 ; right < prices.length; right ++) {
			if (prices[left] < prices[right]) {
				maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
			} else {
				left = right;
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfilt(new int[] {7,1,5,3,6,4}));
	}
}
