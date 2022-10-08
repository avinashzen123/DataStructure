package com.avinash.dynamic;import java.util.Arrays;

interface Constant {
	Integer NUM_OF_EGGS = 2;
	Integer NUM_OF_FLOORS = 100;
}
public class EggDropping {
	private int[][] dpTable = new int[Constant.NUM_OF_EGGS + 1][Constant.NUM_OF_FLOORS + 1];
	
	public int solve() {
		//Fist column is initialized with 1 
		dpTable[0][0] = 1;
		dpTable[1][0] = 1;
		//if we have 1 egg then checking n floors
		for (int i = 0; i < Constant.NUM_OF_FLOORS; i++) {
			dpTable[1][i] = i;
		}
		
		for (int n = 2; n <= Constant.NUM_OF_EGGS; n++) {
			for (int m = 1; m <= Constant.NUM_OF_FLOORS; m++) {
				dpTable[n][m] = Integer.MAX_VALUE;
				//Check dropping the eggs from 1 to the current floor j
				//Note :We can reuse the Subsolutions from the table.
				for (int x = 1; x <=m ; x++) {
					int maxDrops = 1 + Math.max(dpTable[n-1][x-1], dpTable[n][m - x]);
					if (maxDrops < dpTable[n][m]) {
						dpTable[n][m] = maxDrops;
					}
				}
			}
		}
		return dpTable[Constant.NUM_OF_EGGS][Constant.NUM_OF_FLOORS];
	}
	
	public static void main(String[] args) {
		System.out.println(new EggDropping().solve());
	}
}
