package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=We3YDTzNXEk&list=PLkRjB0fkJhoUUyTG5yjcpEVM6nxhJGY0t&index=11
public class MinEdit {

	public static void main(String[] args) {
		var i = "Avinash";
		i = "C";
		System.out.println("Name " +  i);
		System.out.println(findMinEdit("abcdef", "axced"));
	}

	public static int findMinEdit(String str1, String str2) {
		int length1 = str1.length() + 1;
		int length2 = str2.length() + 1;
		int[][] dpTale = new int[length1][];
		dpTale[0] = IntStream.range(0, length2).map(i -> i).toArray();
		IntStream.range(1, length1).forEach(i -> dpTale[i] = new int[length2]);
		IntStream.range(1, length1).forEach(i -> dpTale[i][0] = i);
		for (int i = 1; i < dpTale.length; i++) {
			for (int j = 1; j < dpTale[i].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dpTale[i][j] = dpTale[i - 1][j - 1];
				} else {
					dpTale[i][j] = Math.min(dpTale[i][j - 1], Math.min(dpTale[i - 1][j], dpTale[i - 1][j - 1])) + 1;
				}
			}
		}
		System.out.println(Arrays.stream(dpTale).map(val -> Arrays.toString(val)).collect(Collectors.joining("\n")));
		System.out.println("\n\n");
		return dpTale[str1.length()][str2.length()];
	}

}
