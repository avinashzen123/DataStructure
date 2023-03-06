package com.avinash.string;

import java.util.Arrays;

public class KnuthMorisAlgorithm {

	private static class Implementation {
		private String text;
		private String pattern;
		private int[] pi;
		
		public Implementation(String text, String pattern) {
			this.text = text;
			this.pattern = pattern;
			this.pi = new int[pattern.length()];
			constructTable();
			System.out.println(Arrays.toString(this.pi));
		}
		
		public void constructTable() {
			int prefixCounter = 0;
			int i = 1;
			while (i < pattern.length()) {
				if (text.charAt(i) == pattern.charAt(prefixCounter)) {
					prefixCounter++;
					pi[i] = prefixCounter;
					i++;
				} else {
					if (prefixCounter != 0) {
						prefixCounter = pi[prefixCounter - 1];
					} else {
						pi[i] = 0;
						i++;
					}
				}
			}
		}
		
		public void search() {
			int i = 0;
			int j = 0;
			while( i < text.length() && j < pattern.length()) {
				if (text.charAt(i) == pattern.charAt(j)) {
					i++;
					j++;
				}
				// We have found the pattern (re-initiate the index j to be able to find more pattern.
				if (j == pattern.length()) {
					System.out.println("Found pattern at index " + (i - j));
					j = pi[j - 1];
				}
				// in case of mismatch (the letters are not matching)
				if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
					if (j != 0) {
						j = pi[j - 1];
					} else {
						i++;
					}
				}
			}
		}
	}

	public static boolean knuthMorrisPrattAlgorithm(String pattern, String string) {
		// Write your code here.
		int[] pi = new int[pattern.length()];
		Arrays.fill(pi, -1);
		int index = 1;
		int pattStart = 0;
		while (index < pattern.length()) {
			if (pattern.charAt(index) == pattern.charAt(pattStart)) {
				pi[index] = pattStart;
				index++;
				pattStart++;
			} else if (pattStart > 0) {
				pattStart = pi[pattStart - 1] + 1;
			} else {
				index++;
			}
		}
		System.out.println(Arrays.toString(pi));
		pattStart = 0;
		index = 0;
		while (index + pattern.length() - pattStart <= string.length() ) {
			if (string.charAt(index) == pattern.charAt(pattStart)) {
				if (pattStart == pattern.length() - 1)
					return true;
				index++;
				pattStart++;
			} else if (pattStart > 0) {
				pattStart = pi[pattStart - 1] + 1;
			} else {
				index++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
//		System.out.println(knuthMorrisPrattAlgorithm(pat, txt));
//		
//		System.out.println(knuthMorrisPrattAlgorithm("aefcdaed", "aefoaefcdaefcdaed"));
//		System.out.println(knuthMorrisPrattAlgorithm("fawfawfawfawfa", "testwafwafawfawfawfawfawfawfawfa"));
		
		Implementation implementation = new Implementation(txt, pat);
		implementation.search();
	}
}
