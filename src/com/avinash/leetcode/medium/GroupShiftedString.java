package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedString {
	public static class Solution1 {
		private char shiftLetter(char letter, int shift) {
			return (char) ((letter - shift + 26) % 26 + 'a');
		}
		
		private String getHash(String s) {
			char[] chars = s.toCharArray();
			int shift = chars[0];
			for (int i = 0; i < chars.length; i++) {
				chars[i] = shiftLetter(chars[i], shift);
			}
			String hashKey = String.valueOf(chars);
			return hashKey;
		}
		
		private String getHash1(String s) {
			char[] chars = s.toCharArray();
			StringBuilder hashKey = new StringBuilder();
			for (int i = 1; i < chars.length; i++) {
				hashKey.append((char) ((chars[i] - chars[i-1] + 26) % 26 + 'a'));
			}
			System.out.println(s + " Key " + hashKey.toString());
			return hashKey.toString();
		}
		
		public List<List<String>> groupStrings(String[] strings) {
			Map<String, List<String>> mapHashToList = new HashMap<>();
			for (String str : strings) {
				String hashKey = getHash1(str);
				List<String> value = mapHashToList.getOrDefault(hashKey, new ArrayList<>());
				value.add(str);
				mapHashToList.put(hashKey, value);
			}
			return mapHashToList.values().stream().toList();
		}
		
		public static void main(String[] args) {
			System.out.println(new Solution1().groupStrings(new String[] {"abc","bcd","acef","xyz","az","ba","a","z"}));
		}
	}
}
