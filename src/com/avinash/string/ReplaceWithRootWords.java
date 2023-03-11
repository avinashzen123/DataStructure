package com.avinash.string;

import java.util.List;

public class ReplaceWithRootWords {

	private static class TrieNode {
		private String word;
		private TrieNode[] childrens = new TrieNode[26];
	}
	
	private static class TrieImplementation {
		public static String replaceWords(List<String> dictionary, String sentence) {
			TrieNode trie = new TrieNode();
			for(String str : dictionary) {
				TrieNode cur = trie;
				for (char letter : str.toCharArray()) {
					int index = letter - 'a';
					if (cur.childrens[index] == null) {
						cur.childrens[index] = new TrieNode();
					}
					cur = cur.childrens[index];
				}
				cur.word = str;
			}
			StringBuilder ans = new StringBuilder();
			for (String word : sentence.split("\\s+")) {
				if (ans.length() > 0) {
					ans.append(" ");
				}
				TrieNode cur = trie;
				for (char letter : word.toCharArray()) {
					int index = letter - 'a';
					if  (cur.childrens[index] == null || cur.word != null) {
						break;
					}
					cur = cur.childrens[index];
				}
				ans.append(cur.word != null ? cur.word : word);
			}
			return ans.toString();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(TrieImplementation.replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
	}
}
