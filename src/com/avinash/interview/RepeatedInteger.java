package com.avinash.interview;

public class RepeatedInteger {

	public static void solve(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] = -1 * array[Math.abs(array[i])];
			} else {
				System.out.println("found repetation " + Math.abs(array[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		solve(new int[] {2,3,1,2,4,3});
	}
}
