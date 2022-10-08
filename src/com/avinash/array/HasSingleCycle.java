package com.avinash.array;

public class HasSingleCycle {

	public static boolean hasSingleCycle(int[] array) {
		// Write your code here.f
		int index = 0;
		int visitedCount = 0;
		while (visitedCount < array.length) {
			if (visitedCount > 0 && index == 0) {
				return false;
			}
			visitedCount++;
			int nextIdx = (index + array[index]) % array.length;
			index = nextIdx >= 0 ? nextIdx : nextIdx + array.length;
		}
		return index == 0;
	}

	public static void main(String[] args) {
		System.out.println(hasSingleCycle(new int[] { 2, 3, 1, -4, -4, 2 }));
		System.out.println(hasSingleCycle(new int[] { 2, 2, -1 }));
		System.out.println(hasSingleCycle(new int[] { 1, 1, 1, 1, 1 }));
	}
}
