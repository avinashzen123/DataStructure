package com.avinash.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/word-squares/editorial/
public class WordSquare {

	static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		List<Integer> wordList = new ArrayList<>();
	}
	
	static class UsingTrie {
		int N = 0;
		String[] words = null;
		TrieNode trie = null;
		
		public List<List<String>> wordSquare(String[] words) {
			this.words = words;
			this.N = words[0].length();
			List<List<String>> result = new ArrayList<>();
			this.buildTree(words);
			
			return result;
		}
		
		private void backTrack(int step, LinkedList<String> wordSquares, List<List<String>> result) {
			if (step == N) {
//				result.add(List<String)
			}
		}

		private void buildTree(String[] words) {
			this.trie = new TrieNode();
			
			for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
				String word = words[wordIndex];
				TrieNode node = this.trie;
				for (Character letter : word.toCharArray()) {
					if (node.children.containsKey(letter)) {
						node = node.children.get(letter);
					} else {
						TrieNode newNode = new TrieNode();
						node.children.put(letter, newNode);
						node = newNode;
					}
					node.wordList.add(wordIndex);
				}
			}
		}
		
		private List<Integer> getWordsWithPrefix(String prefix) {
			TrieNode node = this.trie;
			for(Character character : prefix.toCharArray()) {
				if (node.children.containsKey(character)) {
					node = node.children.get(character);
				} else {
					new ArrayList<>();
				}
			}
			return node.wordList;
		}
	}
}
