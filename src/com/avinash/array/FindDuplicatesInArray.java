package com.avinash.array;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicatesInArray {

	public List<Integer> findDuplicates(int[] nums) {
		return Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() >= 2)
				.map(entry -> entry.getKey())
				.toList();
	}
	public static void main(String[] args) {
		List<Integer> duplicates = new FindDuplicatesInArray().findDuplicates(new int[] {4,3,2,7,8,2,3,1});
		System.out.println(duplicates);
	}
}
