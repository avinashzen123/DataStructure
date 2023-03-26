package com.avinash.string;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
	public static String longestCommonPrefix (String[] strs) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			for (String str : strs) {
				if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) {
					return builder.toString();
				}
			}
			builder.append(strs[0].charAt(i));
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
//		System.out.println(longestCommonPrefix(new String[] {""}));
		System.out.println(longestCommonPrefix(new String[] {"flower","flower","flower","flower"}));
	}
}
