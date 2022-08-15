package com.avinash.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static List<List<String>> findLadders(String source, String target, Set<String> dictionary) {
		List<List<String>> result = new ArrayList<>();
		if (!dictionary.contains(target))
			return new ArrayList<>();
		if (dictionary.contains(source)) dictionary.remove(source);
		List<String> currentSequence = new ArrayList<>();
		currentSequence.add(source);
		dfs(source, target, dictionary, currentSequence, result);
		return result;
	}

	private static void dfs(String source, String target, Set<String> dictionary, List<String> currentSequence,
			List<List<String>> result) {
		if (source.equals(target)) {
			result.add(new ArrayList<>(currentSequence));
		} else {
			for (int i = 0; i < source.length(); i++) {
				for (char c = 'a'; c < 'z' ; c++) {
					char[] charArray = source.toCharArray();
					charArray[i] = c;
					String newString = new String(charArray);
					if (dictionary.contains(newString)) {
						dictionary.remove(newString);
						currentSequence.add(newString);
						dfs(newString, target, dictionary, currentSequence, result);
						currentSequence.remove(newString);
						dictionary.add(newString);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String start = "cog";
		String end = "hit";
		Set<String> dict = new HashSet<>();
		dict.add("hit");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cit");
//		dict.add("cog");
		List<List<String>> findLadders = findLadders(start, end, dict);
		findLadders.stream().forEach(System.out::println);
		
	}
}
