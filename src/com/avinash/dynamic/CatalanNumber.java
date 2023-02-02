package com.avinash.dynamic;

import java.util.HashMap;

class CatalanNumberRecursive {
	public static int calculateCatalan(int number) {
		if (number <= 1) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < number; i++) {
			result += calculateCatalan(i) * calculateCatalan(number - i - 1);
		}
		return result;
	}
}

class CatalanNumberDynamic {
	public static int calculateCatalan(int number) {
		int[] cataln = new int[number + 1];
		cataln[0] = 1;
		cataln[1] = 1;
		for (int i = 2; i <= number; i++) {
			cataln[i] = 0;
			for (int j = 0; j < i; j++) {
				cataln[i] += cataln[j] * cataln[i - j - 1];
			}
		}
		return cataln[number];
	}
}

public class CatalanNumber {

	public static void main(String[] args) {
		System.out.println(CatalanNumberRecursive.calculateCatalan(6));
		System.out.println(CatalanNumberDynamic.calculateCatalan(6));
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(null, 1);
		System.out.println(map);
	}
}
