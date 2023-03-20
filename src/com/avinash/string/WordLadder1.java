package com.avinash.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/word-ladder/description/
/**
 * Time Complexity: O(M^2×N), where M is the length
 * of each word and N is the total number of words in the input word list.
 * 
 *
 */
public class WordLadder1 {
	static class Pair<U, V> {
		U key;
		V value;

		Pair(U first, V value) {
			this.key = first;
			this.value = value;
		}
	}

	static class UsingBFS {
		static int length(String beginWord, String endWord, List<String> wordList) {
			int length = beginWord.length();
			Map<String, List<String>> allComboDict = new HashMap<>();
			wordList.forEach(word -> {
				for (int i = 0; i < length; i++) {
					String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
					List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
					transformations.add(word);
					allComboDict.put(newWord, transformations);
				}
			});
			Queue<Pair<String, Integer>> queue = new LinkedList<>(); // Queue for BFS
			queue.add(new Pair<>(beginWord, 1));

			Map<String, Boolean> visited = new HashMap<>();
			visited.put(beginWord, true);

			while (!queue.isEmpty()) {
				Pair<String, Integer> node = queue.poll();
				String word = node.key;
				Integer level = node.value;
				for (int i = 0; i < length; i++) {
					String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
					for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
						if (adjacentWord.equals(endWord)) {
							return level + 1;
						}
						if (!visited.containsKey(adjacentWord)) {
							visited.put(adjacentWord, true);
							queue.add(new Pair<>(adjacentWord, level + 1));
						}
					}
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		System.out.println(UsingBFS.length(beginWord, endWord, Arrays.stream(wordList).toList()));
	}
}
