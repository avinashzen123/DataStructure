package com.avinash.dynamic.oned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s = "leetcode", dict = ["leet", "code"]. Return true
 * because "leetcode" can be segmented as "leet code".
 * 
 * @author LENOVO
 *
 */
public class WordBreak {

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary words.
	 * For example, given s = "leetcode", dict = ["leet", "code"]. Return true
	 * because "leetcode" can be segmented as "leet code".
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true; // We set first to true because we need initial state
		for (int i = 0; i < s.length(); i++) {
			if (!t[i])
				continue;
			for (String a : dict) {
				int len = a.length();
				int end = i + len;
				if (end > s.length())
					continue;
				if (t[end])
					continue;
				if (s.substring(i, end).equals(a)) {
					t[end] = true;
				}
			}
		}
		System.out.println(Arrays.toString(t));
		return t[s.length()];
	}

	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct
	 * a sentence where each word is a valid dictionary word. Return all such
	 * possible sentences. 
	 * 
	 * For example, given s = "catsanddog", dict = ["cat",
	 * "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand
	 * dog"].
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static List<String> splittingSpacelessSentence(String s, Set<String> dict) {
		List<String> dp[] = new List[s.length() + 1];
		dp[0] = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if(dp[i] == null) continue;
			for(String word: dict) {
				int length = word.length();
				int end = i + length;
				if(end > s.length()) continue;
				if(s.subSequence(i, end).equals(word)) {
					if(dp[end] == null) {
						dp[end] = new ArrayList<>();
					}
					dp[end].add(word);
				}
			}
		}
		List<String> result = new LinkedList<>();
		if(dp[s.length()] == null) {
			return result;
		}
		dfs(dp, s.length(), result, new ArrayList<>());
		return result;
	}

	private static void dfs(List<String>[] dp, int end, List<String> result, 
			List<String> temp) {
		if (end <= 0) {
			String path = temp.get(temp.size() - 1);
			for (int i = temp.size() - 2; i >= 0; i--) {
				path += " " + temp.get(i);
			}
			result.add(path);
			return;
		}
		for (String str: dp[end]) {
			temp.add(str);
			dfs(dp, end-str.length(), result, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		String str = "programcreek";
		Set<String> dict = Set.of("program", "creek");
		System.out.println(wordBreak(str, dict));
		
		String s = "catsanddog";
		Set<String> d = new HashSet<>();
		d.add("cat");
		d.add("cats");
		d.add("and");
		d.add("sand");
		d.add("dog");
		System.out.println(splittingSpacelessSentence(s, d));
	}
}
