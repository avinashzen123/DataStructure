package com.avinash.interview;

public class InterleavingString {

	 // https://www.youtube.com/watch?v=3Rw3p9LrgvE
    public static boolean isInterleave(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        boolean[][] dpTable = new boolean[str1.length() + 1][str2.length() + 1];
        dpTable[str1.length()][str2.length()] = true;
        for (int row = str1.length(); row >= 0; row--) {
            for (int col = str2.length(); col >= 0; col--) {
                if (row < str1.length() && str1.charAt(row) == str3.charAt(row + col) && dpTable[row + 1][col]) {
                    dpTable[row][col] = true;
                }
                if (col < str2.length() && str2.charAt(col) == str3.charAt(row + col) && dpTable[row][col+1]) {
                    dpTable[row][col] = true;
                }
            }
        }
        return dpTable[0][0];
    }

    
	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabcc"; 
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
	}
}
