package com.avinash.dynamic;import java.util.Arrays;

interface Constant {
	Integer NUM_OF_EGGS = 3;
	Integer NUM_OF_FLOORS = 100;
}
public class EggDropping {
	private int[][] dpTable = new int[Constant.NUM_OF_EGGS + 1][Constant.NUM_OF_FLOORS + 1];
	
	public int solve() {
		// Fist column is initialized with 1
		dpTable[0][0] = 1;
		dpTable[1][0] = 1;
		// if we have 1 egg then checking n floors
		for (int i = 0; i < Constant.NUM_OF_FLOORS; i++) {
			dpTable[1][i] = i;
		}

//		Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
//		System.out.println("\n\n");
		for (int egg = 2; egg <= Constant.NUM_OF_EGGS; egg++) {
			for (int floor = 1; floor <= Constant.NUM_OF_FLOORS; floor++) {
				dpTable[egg][floor] = Integer.MAX_VALUE;
				// Check dropping the eggs from 1 to the current floor j
				// Note :We can reuse the Subsolutions from the table.
				for (int curFloor = 1; curFloor <= floor; curFloor++) {
					int maxDrops = 1 + Math.max(dpTable[egg - 1][curFloor - 1], dpTable[egg][floor - curFloor]);
					if (maxDrops < dpTable[egg][floor]) {
						dpTable[egg][floor] = maxDrops;
//						Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
//						System.out.println("\n\n");
					}
				}
			}
		}
		Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
		return dpTable[Constant.NUM_OF_EGGS][Constant.NUM_OF_FLOORS];
	}

	public static void main(String[] args) {
		System.out.println(new EggDropping().solve());
	}
}
