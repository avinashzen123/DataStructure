package com.avinash.string;

import java.util.Arrays;

public class KnuthMorisAlgorithm {


	public static boolean knuthMorrisPrattAlgorithm(String substring, String string) {
		// Write your code here.
		int[] substringMatchIndex = new int[substring.length()];
		Arrays.fill(substringMatchIndex, -1);
		int index = 1;
		int pattStart = 0;
		while (index < substring.length()) {
			if (substring.charAt(index) == substring.charAt(pattStart)) {
				substringMatchIndex[index] = pattStart;
				index++;
				pattStart++;
			} else if (pattStart > 0) {
				pattStart = substringMatchIndex[pattStart - 1] + 1;
			} else {
				index++;
			}
		}
		System.out.println(Arrays.toString(substringMatchIndex));
		pattStart = 0;
		index = 0;
		while (index + substring.length() - pattStart <= string.length() ) {
			if (string.charAt(index) == substring.charAt(pattStart)) {
				if (pattStart == substring.length() - 1)
					return true;
				index++;
				pattStart++;
			} else if (pattStart > 0) {
				pattStart = substringMatchIndex[pattStart - 1] + 1;
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
