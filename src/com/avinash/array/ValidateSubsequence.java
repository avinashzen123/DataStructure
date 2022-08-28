package com.avinash.array;

import java.util.List;

public class ValidateSubsequence {

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		if (sequence.size() == 0)
			return true;
		if (array.contains(sequence.get(0))) {
			return isValidSubsequence(array.subList(array.indexOf(sequence.get(0)) + 1, array.size()),
					sequence.subList(1, sequence.size()));
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
		List<Integer> sequence = List.of(1, 6, -1, 10, 11, 11, 11, 11);
//		List<Integer>  array = List.of(1, 1, 1, 1, 1);
//		List<Integer>  sequence = List.of(1, 1, 1);
		System.out.println(isValidSubsequence(array, sequence));
	}
}
