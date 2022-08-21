package com.avinash.interview;

import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=WgymCY4NFb8&list=PL5DyztRVgtRVr1katnCAdGdp02nJrDHv6&index=9
public class SubsetSum {

	public static boolean canMakeSumUsing2DMatrix(int[] values, int target) {
		boolean[][] table = new boolean[values.length+1][target+1];
		
		IntStream.range(0, values.length+1).forEach(i -> table[0][i] = true);
		
		for (int row = 1; row <= values.length; row++) {
			for (int col = 1; col <= target; col++) {
				if (col < values[row-1]) 
					table[row][col] = table[row-1][col];
				else if (col >= values[row-1]) {
					int need = col - values[row-1];
					if (table[row-1][col] || table[row-1][need]) {
						table[row][col] = true;
					}else {
						table[row][col] = false;
					}
				}
			}
		}
		return table[values.length][target];
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,3,4};
		int target = 7;
		System.out.println(canMakeSumUsing2DMatrix(arr, target));
	}
}
