package com.avinash.string;

import java.util.ArrayList;
import java.util.List;

public class UnderScoringSubString {
	public static String underscorifySubstring(String str, String substring) {
		// Write your code here.
		List<int[]> indices = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == substring.charAt(0)) {
				int j = i;
				int k = 0;
				while (k < substring.length() && j < str.length() && str.charAt(j) == substring.charAt(k)) {
					j++;
					k++;
				}
				if (k == substring.length()) {
					indices.add(new int[] { i, i + k });
				}
			}
		}
		List<int[]> collapse = new ArrayList<>();
		for (int i = 0; i < indices.size(); i++) {
			int[] arr = { indices.get(i)[0], indices.get(i)[1] };
			while (i + 1 < indices.size() && indices.get(i + 1)[0] <= arr[1]) {
				arr[1] = indices.get(i + 1)[1];
				i++;
			}
			collapse.add(arr);
		}
		StringBuffer buff = new StringBuffer();
		if (collapse.size() > 0 && collapse.get(0)[0] > 0)
			buff.append(str.substring(0, collapse.get(0)[0]));
		for (int i = 0; i < collapse.size(); i++) {
			if (i > 0) {
				buff.append(str.subSequence(collapse.get(i - 1)[1], collapse.get(i)[0]));
			}
			buff.append("_" + str.substring(collapse.get(i)[0], collapse.get(i)[1]) + "_");
		}
		if (collapse.size() > 0 && collapse.get(collapse.size() - 1)[1] < str.length()) {
			buff.append(str.substring(collapse.get(collapse.size() - 1)[1]));
		}
		return collapse.size() == 0 ? str : buff.toString();
	}

	public static void main(String[] args) {
//		System.out.println(underscorifySubstring("testthis is a testtest to see if testestest it works", "test"));
		System.out.println(underscorifySubstring("test this is a test to see if it works", "test"));
	}
}
