package com.avinash.interview;

import java.util.Map;

public class InterleavingString {

	public static boolean isInterleavingString (String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) 
			return false;
		
		
		return true;
	}
	
	private static boolean dfs(String s1, String s2, String s3, Map<String, Boolean> table, int i, int j) {
		if (i == s1.length() && j == s2.length()) 
			return true;
		if (table.containsKey("" + i + "," + j)) 
			return table.get("" + i + "," + j);
		
		if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, table, i + 1, j)) {
			return true;
		}
		if (j < s2.length() && s2.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, table, i, j+1)) {
			return true;
		}
//		table["" + i + "," + j] = false;
		return false;
	}
	
	public static void main(String[] args) {
//		isInterLeav("aabcc", "dbbca", "aadbbcbcac")
	}
}
