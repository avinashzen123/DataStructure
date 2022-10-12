package com.avinash.dynamic;

import java.util.Arrays;

public class InterWeavingString {

	 // https://www.youtube.com/watch?v=3Rw3p9LrgvE
    public static boolean isInterleave(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        boolean[][] dpTable = new boolean[str1.length() + 1][str2.length() + 1];
        dpTable[str1.length()][str2.length()] = true;
        for (int str1Idx = str1.length(); str1Idx >= 0; str1Idx--) {
            for (int str2Idx = str2.length(); str2Idx >= 0; str2Idx--) {
                if (str1Idx < str1.length() && str1.charAt(str1Idx) == str3.charAt(str1Idx + str2Idx) && dpTable[str1Idx + 1][str2Idx]) {
                    dpTable[str1Idx][str2Idx] = true;
                }
                if (str2Idx < str2.length() && str2.charAt(str2Idx) == str3.charAt(str1Idx + str2Idx) && dpTable[str1Idx][str2Idx+1]) {
                    dpTable[str1Idx][str2Idx] = true;
                }
            }
        }
        Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
        return dpTable[0][0];
    }

    
	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabcc"; 
        s2 = "dbbca";
        s3 = "aadbbbaccc";
//        System.out.println(isInterleave(s1, s2, s3));
	}
}
