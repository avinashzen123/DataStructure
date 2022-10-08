package com.avinash.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxCharacterForWords {
	public static char[] minimumCharactersForWords(String[] words) {
		// Write your code here.
		Map<Character, Integer> maxCharFreq = new HashMap<>();
		for (String word : words) {
			Map<Character, Integer> charFreq = new HashMap<>();
			for (char c : word.toCharArray()) {
				charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
			}
			for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
				maxCharFreq.put(entry.getKey(),
						Math.max(entry.getValue(), maxCharFreq.getOrDefault(entry.getKey(), 0)));
			}
		}
		List<Character> list = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : maxCharFreq.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				list.add(entry.getKey());
			}
		}
		char ch[] = new char[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ch[i] = list.get(i);
		}
		return ch;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(minimumCharactersForWords(new String[] {"this", "that", "did", "deed", "them!", "a"})));
	}
}
