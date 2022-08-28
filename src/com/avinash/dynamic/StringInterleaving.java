package com.avinash.dynamic;

import java.util.Arrays;

public class StringInterleaving {
	
	
	public static boolean isInterleaving(String source1, String source2, String target) {
		if (source1.isEmpty() && source2.isEmpty() && target.isEmpty()) return true;
		if (target.length() != source1.length() + source2.length())	return false;
//		System.out.println(source1 + "\t" + source2 + "\t" + target);
		return (!source1.isEmpty() && source1.charAt(0) == target.charAt(0) 
				&& isInterleaving(source1.substring(1), source2, target.substring(1)))
			|| (!source2.isEmpty() && source2.charAt(0) == target.charAt(0) 
				&& isInterleaving(source1, source2.substring(1), target.substring(1)));
	}
	
	public static boolean isInterleavingDp(String source1, String source2, String target) {
		boolean[][] dpTable = new boolean[source1.length() + 1][source2.length() + 1];
		dpTable[0][0] = true;
		for (int index = 1; index <= source2.length(); index++) {
			dpTable[0][index] = source2.charAt(index-1) == target.charAt(index-1) ? dpTable[0][index-1] : false;
		}
		for (int index = 1; index <= source1.length(); index++) {
			dpTable[index][0] = source1.charAt(index-1) == target.charAt(index-1) ? dpTable[index-1][0] : false;
		}
		
		for (int row = 1; row <= source1.length(); row++) {
			for (int col = 1; col <= source2.length(); col++) {
				char targetChar = target.charAt(row + col - 1);
				if (targetChar == source1.charAt(row -1)) {
					dpTable[row][col] = dpTable[row-1][col];
				} 
				if (targetChar == source2.charAt(col - 1)) {
					dpTable[row][col] = dpTable[row][col-1]|| dpTable[row][col];
				}
 			}
		}
		
//		Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
		return dpTable[source1.length()][source2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isInterleavingDp("abx", "mbx", "abxmbx" ));
		System.out.println(isInterleaving("abacde", "decab", "adbeaccadbe" ));

	}
}
