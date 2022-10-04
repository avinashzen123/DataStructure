package com.avinash.dynamic;

import java.util.Arrays;

public class MinNumberOfJumps {

	public static int minNumberOfJumps(int[] array) {
		int[] table = new int[array.length];
		Arrays.fill(table, array.length + 1);
		table[0] = 0;
		for (int i = 1 ; i < array.length; i++) {
			for (int j = 0; j < i ; j++) {
				if (array[j] + j >= i)  {
					table[i] = Math.min(table[i], table[j] + 1);
				}
			}
		}
		System.out.println(Arrays.toString(table));
		return table[table.length - 1];
	}
	
	// Not working for all test cases
	public static int minNumberOfJumps1(int[] array) {
		int jump = 0;
		int maxReach = array[0];
		int steps = array[0];
		for (int i = 1; i < array.length ; i++) {
			steps--;
			maxReach = Math.max(maxReach, i + array[i]);
			if (steps == 0) {
				jump++;
				steps = maxReach - i;
			}
		}
		return jump + 1;
	}

	public static void main(String[] args) {
		System.out.println(minNumberOfJumps(new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 }));
	}
}
