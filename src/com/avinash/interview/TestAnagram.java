package com.avinash.interview;

import java.util.Map;
import java.util.stream.Collectors;

public class TestAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("spot", "post"));
	}
	
	public static boolean isAnagram (String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		Map<Integer, Long> keyMap = str1.chars().boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		str1.chars().boxed().filter(keyMap::containsKey).forEach(c -> keyMap.put(c, keyMap.get(c) - 1));
		return keyMap.values().stream().mapToLong(i -> i).sum() == 0;
	}
}
