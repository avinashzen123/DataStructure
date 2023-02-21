package com.avinash.interview;

// https://leetcode.com/problems/shortest-word-distance/description/
public class ShortestWordDistance {
	public static int shortestDistance(String[] wordsDict, String word1, String word2) {
		int result = Integer.MAX_VALUE;
		int word1Idx = -1;
		int word2Idx = -1;
		for (int index = 0; index < wordsDict.length; index++) {
			String str = wordsDict[index];
			if (word1.equals(str)) {
				word1Idx = index;
			} else if (word2.equals(str)) {
				word2Idx = index;
			}
			if (word1Idx != -1 && word2Idx != -1)
				result = Math.min(result, Math.abs(word1Idx - word2Idx));
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding", word2 = "practice";
		System.out.println(shortestDistance(wordsDict, word1, word2));

	}
}
