package com.avinash.string;

public class BruteForcePatternSearch {

    public int search(String str, String pattern) {
        int lengthOfText = str.length();
        int lengthOfPattern = pattern.length();
        for (int i = 0; i <= lengthOfText - lengthOfPattern ; i++) {
            int j = 0;
            for (j = 0; j < lengthOfPattern; j++) {
                if (str.charAt( i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == lengthOfPattern) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForcePatternSearch bruteForcePatternSearch = new BruteForcePatternSearch();
        System.out.println(bruteForcePatternSearch.search("ttttta", "tta"));
    }
}
