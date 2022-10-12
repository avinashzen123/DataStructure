package com.avinash.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> res = new TreeMap<>();
		for (int i = strs.length - 1; i >= 0; i--) {
			String s = strs[i];
			int count = s.chars().sum();
			if (res.containsKey(count)) {
				res.get(count).add(s);
			} else {
				List<String> st = new ArrayList<>();
				st.add(s);
				res.put(count, st);
			}
		}
		List<List<String>> res1 = new ArrayList<>(res.values());
		Collections.sort(res1, (o1, o2) -> Integer.compare(o1.size(), o2.size()));
		return res1;
	}

	public static List<List<String>> groupAnagrams(List<String> words) {
		Map<String, List<String>> map = new TreeMap<>();
		for (String word : words) {
			String sortedString = word.chars().sorted().mapToObj(c -> Character.toString(c))
					.collect(Collectors.joining());

			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(word);
			} else {
				map.put(sortedString, new ArrayList<>());
				map.get(sortedString).add(word);
			}
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
//		strs = new String[]{"ac","c"};
		System.out.println(groupAnagrams(strs));

	}
}
