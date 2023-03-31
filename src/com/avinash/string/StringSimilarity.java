package com.avinash.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/sentence-similarity/description/
/**
 * We can represent a sentence as an array of words, for example, the sentence
 * "I am happy with leetcode" can be represented as arr =
 * ["I","am",happy","with","leetcode"].
 * 
 * Given two sentences sentence1 and sentence2 each represented as a string
 * array and given an array of string pairs similarPairs where similarPairs[i] =
 * [xi, yi] indicates that the two words xi and yi are similar.
 * 
 * Return true if sentence1 and sentence2 are similar, or false if they are not
 * similar.
 * 
 * Two sentences are similar if:
 * 
 * They have the same length (i.e., the same number of words) sentence1[i] and
 * sentence2[i] are similar. Notice that a word is always similar to itself,
 * also notice that the similarity relation is not transitive. For example, if
 * the words a and b are similar, and the words b and c are similar, a and c are
 * not necessarily similar.
 * 
 * Input: sentence1 = ["great","acting","skills"], sentence2 =
 * ["fine","drama","talent"], similarPairs =
 * [["great","fine"],["drama","acting"],["skills","talent"]]
 * 
 * Output: true
 * 
 * Explanation: The two sentences have the same length and each word i of
 * sentence1 is also similar to the corresponding word in sentence2.
 * 
 * Input: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
 * 
 * Output: true
 * 
 * Explanation: A word is similar to itself.
 * 
 */
public class StringSimilarity {
	static boolean areSentenceSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
		if (sentence1.length != sentence2.length)
			return false;
		Map<String, Set<String>> wordsSimilarWords = new HashMap<>();
		for (List<String> pair : similarPairs) {
			wordsSimilarWords.computeIfAbsent(pair.get(0), value -> new HashSet<>()).add(pair.get(1));
			wordsSimilarWords.computeIfAbsent(pair.get(1), value -> new HashSet<>()).add(pair.get(0));
		}
		for (int i = 0; i < sentence1.length; i++) {
			if (sentence1[i].equals(sentence2[i])) {
				continue;
			}
			if (wordsSimilarWords.containsKey(sentence1[i])
					&& wordsSimilarWords.get(sentence1[i]).contains(sentence2[i])) {
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] sentence1 = { "great", "acting", "skills" };
		String[] sentence2 = { "fine", "drama", "talent" };
		List<List<String>> similarWord = List.of(List.of("great","fine"),List.of("drama","acting"),List.of("skills","talent"));
		System.out.println(areSentenceSimilar(sentence1, sentence2, similarWord));
	}
}
