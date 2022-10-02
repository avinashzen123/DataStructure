package com.avinash.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneNumberMnemonics {
	private Map<Integer, List<Character>> mnemonicsMap = Map.of(0, List.of(), 1, List.of(), 2, List.of('a', 'b', 'c'),
			3, List.of('d', 'e', 'f'), 4, List.of('g', 'h', 'i'), 5, List.of('j', 'k', 'l'), 6, List.of('m', 'n', 'o'),
			7, List.of('p', 'q', 'r', 's'), 8, List.of('t', 'u', 'v'), 9, List.of('w', 'x', 'y', 'z'));

	public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		ArrayList<String> result = new ArrayList<>();
		phoneNumberMnemonics(phoneNumber, new String[phoneNumber.length()], result, 0);
		return result;
	}

	private void phoneNumberMnemonics(String phoneNumber, String[] mnemonics, List<String> result, int index) {
		if (index == phoneNumber.length()) {
			result.add(Arrays.stream(mnemonics).collect(Collectors.joining()));
		} else {
			if (mnemonicsMap.get(Integer.valueOf(phoneNumber.charAt(index) - '0')).isEmpty()) {
				mnemonics[index] = phoneNumber.charAt(index) + "";
				phoneNumberMnemonics(phoneNumber, mnemonics, result, index + 1);
			} else {
				for (char c : mnemonicsMap.get(Integer.valueOf(phoneNumber.charAt(index) - '0'))) {
					mnemonics[index] = c + "";
					phoneNumberMnemonics(phoneNumber, mnemonics, result, index + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> phoneNumberMnemonics = new PhoneNumberMnemonics().phoneNumberMnemonics("1905");
		System.out.println(phoneNumberMnemonics.size());
		for (String s : phoneNumberMnemonics) {
			System.out.println(s);
		}
	}
}
