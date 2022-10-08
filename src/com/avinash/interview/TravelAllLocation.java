package com.avinash.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TravelAllLocation {
	public static int solution(int[] a) {
		Set<Integer> locations = Arrays.stream(a).boxed().collect(Collectors.toSet());
		int minSize = Integer.MAX_VALUE;
		int curMax = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			minSize = Math.min(minSize, solution(a, i, new HashSet<>(locations)) - i);
		}
		return minSize;
	}
	
	private static int solution(int[] a, int index, Set<Integer> locations) {
		if (locations.isEmpty()) {
			return index;
		}
		if (index >= a.length) {
			return Integer.MAX_VALUE;
		}
		locations.remove(a[index]);
		return solution(a, index + 1, locations);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {7,3,7,3,1,3,4,1}));
	}
}
