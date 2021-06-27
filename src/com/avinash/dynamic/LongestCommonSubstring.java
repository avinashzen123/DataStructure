package com.avinash.dynamic;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "lblcdemf";
		System.out.println(longestCommonSubstring(str1, str2, str1.length() - 1, str2.length() - 1, false));
	}

	public static int longestCommonSubstring(String str1, String str2, int pos1, int pos2, boolean checkEqual) {
		if (pos1 == -1 || pos2 == -1) {
			return 0;
		}
		if (checkEqual) {
			if (str1.charAt(pos1) == str2.charAt(pos2)) {
				return 1 + longestCommonSubstring(str1, str2, pos1 - 1, pos2 - 1, checkEqual);
			} else {
				return 0;
			}
		}
		int result = 0;
		if (str1.charAt(pos1) == str2.charAt(pos2)) {
			result = 1 + longestCommonSubstring(str1, str2, pos1 - 1, pos2 - 1, true);
		}
		return Math.max(result, Math.max(longestCommonSubstring(str1, str2, pos1 - 1, pos2, false),
				longestCommonSubstring(str1, str2, pos1, pos2 - 1, false)));
	}
}
