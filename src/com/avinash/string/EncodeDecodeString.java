package com.avinash.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/editorial/
public class EncodeDecodeString {
	private String encodeLength(String str) {
		char[] bytes = new char[4];
		int length = str.length();
		for (int i = 3; i >= 0; i--) {
			bytes[3 - i] = (char) (length >> (i * 8));
		}
		return new String(bytes);
	}

	private int decodeLength(String str) {
		String lengthStr = str.substring(0, 4);
		int result = 0;
		for (char ch : lengthStr.toCharArray()) {
			result = (result << 8) + (int) ch;
		}
		return result;
	}

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder builder = new StringBuilder();
		for (String str : strs) {
			builder.append(encodeLength(str));
			builder.append(str);
		}
		return builder.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> result = new ArrayList<>();
		while (s.length() != 0) {
			int length = decodeLength(s);
			String str = s.substring(4, length + 4);
			result.add(str);
			s = s.substring(4 + length);
		}
		return result;
	}

	public static void main(String[] args) {
		EncodeDecodeString encode = new EncodeDecodeString();
		String encodedStr = encode.encode(List.of("Avinash Kumar Sharma", "Kumar", "Sharma"));
		System.out.println(encodedStr);
		List<String> decoded = encode.decode(encodedStr);
		System.out.println(decoded);
	}
}
