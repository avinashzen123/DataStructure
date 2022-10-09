package com.avinash.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskStacking {

	// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
	
	public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		// Write your code here.
		disks.sort((a, b) -> (a[0] * a[1]) - (b[0] * b[1]));
		int[] sol = new int[disks.size()];
		for (int i = 0; i < disks.size(); i++) {
			sol[i] = disks.get(i)[2];
		}
		int[] seq = new int[disks.size()];
		Arrays.fill(seq, -1);
		Integer maxIdx = 0;
		// Iterate over the disks (saved in c) and them the disk smaller than it (saved
		// in 0)
		for (int i = 0; i < disks.size(); i++) {
			Integer[] c = disks.get(i);
			for (int j = i - 1; j >= 0; j--) {
				Integer[] o = disks.get(j);
				// Make sure that the disk that is going on top is smaller in all the sense
				// Then check if the current tower is bigger adding the tower buliding
				// previously
				if (o[0] < c[0] && o[1] < c[1] && o[2] < c[2] && sol[j] + c[2] > sol[i]) {
//					sol[i] = sol[j] + c[2];
					 sol[i] = j;
				}
			}
			maxIdx = sol[maxIdx] < sol[i] ? i : maxIdx;
		}

		ArrayList<Integer[]> result = new ArrayList<>();
		result.add(disks.get(maxIdx));
		while (seq[maxIdx] != -1) {
			result.add(0, disks.get(seq[maxIdx]));
			maxIdx = seq[maxIdx];
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer[]> input = new ArrayList<Integer[]>();
	    input.add(new Integer[] {2, 1, 2});
	    input.add(new Integer[] {3, 2, 3});
	    input.add(new Integer[] {2, 2, 8});
	    input.add(new Integer[] {2, 3, 4});
	    input.add(new Integer[] {2, 2, 1});
	    input.add(new Integer[] {4, 4, 5});
	    
	    List<Integer[]> diskStacking = diskStacking(input);
	    diskStacking.stream().map(Arrays::stream).forEach(System.out::println);
	    
	    List<Integer[]> expected = new ArrayList<Integer[]>();
	    expected.add(new Integer[] {2, 1, 2});
	    expected.add(new Integer[] {3, 2, 3});
	    expected.add(new Integer[] {4, 4, 5});
	}
}
