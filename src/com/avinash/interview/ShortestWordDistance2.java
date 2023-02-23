package com.avinash.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/shortest-word-distance-ii/
public class ShortestWordDistance2 {
	Map<String, List<Integer>> locations;

	public ShortestWordDistance2(final String[] words) {
		this.locations = new HashMap<>();
		for (int index = 0; index < words.length; index++) {
			List<Integer> location = this.locations.getOrDefault(words[index], new ArrayList<>());
			location.add(index);
			this.locations.put(words[index], location);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> loc1 = this.locations.get(word1);
		List<Integer> loc2 = this.locations.get(word2);
		int loc1Idx = 0;
		int loc2Idx = 0;
		int minDiff = Integer.MAX_VALUE;
		while (loc1Idx < loc1.size() && loc2Idx < loc2.size()) {
			minDiff = Math.min(minDiff, Math.abs(loc1.get(loc1Idx) - loc2.get(loc2Idx)));
			if (loc1.get(loc1Idx) < loc2.get(loc2Idx)) {
				loc1Idx++;
			} else {
				loc2Idx++;
			}
		}
		return minDiff;
	}

	public static void main(String[] args) {
		String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
		String word1 = "coding", word2 = "practice";
		ShortestWordDistance2 distance2 = new ShortestWordDistance2(wordsDict);
		System.out.println(distance2.shortest(word1, word2));
	}
}
