package com.avinash.string;

import java.util.TreeMap;

public class FindAllPalindroms {

    static void palindromeSubStr(String str) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int n = str.length();

        int[][] r = new int[2][n + 1];

        str = "@" + str + "#";
        for (int j = 0; j <=1; j++ ) {
            int rp = 0; // Length of palindrome radius
            r[j][0] = 0;
            int i = 1;
            while (i <= n) {
                while (str.charAt(i - rp - 1) == str.charAt(i + j + rp)) {
                    rp ++;
                }
                r[j][i] = rp;

            }
        }
    }
}
