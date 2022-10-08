package com.avinash.string;

import java.util.Arrays;

public class KnuthMorisAlgorithm {


	public static boolean knuthMorrisPrattAlgorithm(String substring, String string) {
		// Write your code here.
		int[] substringMatchIndex = new int[substring.length()];
		Arrays.fill(substringMatchIndex, -1);
		int index = 1;
		int len = 0;
		while (index < substring.length()) {
			if (substring.charAt(index) == substring.charAt(len)) {
				substringMatchIndex[index] = len;
				index++;
				len++;
			} else if (len > 0) {
				len = substringMatchIndex[len - 1] + 1;
			} else {
				index++;
			}
		}
		System.out.println(Arrays.toString(substringMatchIndex));
		len = 0;
		index = 0;
		while (index + substring.length() - len <= string.length() ) {
			if (string.charAt(index) == substring.charAt(len)) {
				if (len == substring.length() - 1)
					return true;
				index++;
				len++;
			} else if (len > 0) {
				len = substringMatchIndex[len - 1] + 1;
			} else {
				index++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		System.out.println(knuthMorrisPrattAlgorithm(pat, txt));
		
		System.out.println(knuthMorrisPrattAlgorithm("aefcdaed", "aefoaefcdaefcdaed"));
		System.out.println(knuthMorrisPrattAlgorithm("fawfawfawfawfa", "testwafwafawfawfawfawfawfawfawfa"));
	}
}
