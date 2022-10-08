package com.avinash.dynamic.oned;

import java.util.Arrays;

public class DecodeWays {

	public static int numDecoding(String s) {
		int length = s.length();
		int dp[] = new int[length + 1];
		Arrays.fill(dp, 1);
		char[] charArray = s.toCharArray();
		for (int i = length - 1; i >= 0; i--) {
			if (charArray[i] == '0')
				dp[i] = 0;
			else
				dp[i] = dp[i + 1];
			if (i + 1 < length
					&& (charArray[i + 1] == '1' || (charArray[i] == '2' && Integer.parseInt(charArray[i + 1] + "") >= 0
							|| Integer.parseInt(charArray[i + 1] + "") < 7))) {
				dp[i] += dp[i + 2];
			}
		}
		return dp[0];
	}

	/*
	 * A message containing letters from A-Z can be encoded into numbers using the
	 * following mapping:
	 * 
	 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26"
	 * 
	 * To decode an encoded message, all the digits must be grouped then mapped back
	 * into letters using the reverse of the mapping above (there may be multiple
	 * ways). For example, "11106" can be mapped into:
	 *
	 * "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6)
	 * 
	 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped
	 * into 'F' since "6" is different from "06".
	 * 
	 * Given a string s containing only digits, return the number of ways to decode
	 * it.
	 * 
	 * 
	 * Input: s = "12"
	 * 
	 * Output: 2
	 * 
	 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
	 * 
	 * Input: s = "226"
	 * 
	 * Output: 3
	 * 
	 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
	 * 2 6)
	 * 
	 */
	public static int numDecodings(String s) {
		int dp[] = new int[s.length() + 1];
		Arrays.fill(dp, 1);
		for (int i = s.length() - 1; i >= 0; i--) {
			char curChar = s.charAt(i);
			if (curChar == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i + 1];
			}
			if (i + 1 < s.length()) {
				int val = Integer.valueOf(s.substring(i, i + 2));
				if (val >= 10 && val < 27 && String.valueOf(val).length() == 2) {
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

	// https://leetcode.com/problems/decode-ways-ii/

	/*
	 * In addition to the mapping above, an encoded message may contain the '*'
	 * character, which can represent any digit from '1' to '9' ('0' is excluded).
	 * For example, the encoded message "1*" may represent any of the encoded
	 * messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding
	 * "1*" is equivalent to decoding any of the encoded messages it can represent.
	 * 
	 * Given a string s consisting of digits and '*' characters, return the number
	 * of ways to decode it.
	 * 
	 * Since the answer may be very large, return it modulo 109 + 7.
	 * 
	 * Input: s = "*"
	 * 
	 * Output: 9
	 * 
	 * Explanation: The encoded message can represent any of the encoded messages
	 * "1", "2", "3", "4", "5", "6", "7", "8", or "9". Each of these can be decoded
	 * to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
	 * Hence, there are a total of 9 ways to decode "*".
	 * 
	 * Input: s = "1*"
	 * 
	 * Output: 18
	 * 
	 * Explanation: The encoded message can represent any of the encoded messages
	 * "11", "12", "13", "14", "15", "16", "17", "18", or "19". Each of these
	 * encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA"
	 * or "K"). Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
	 * 
	 * Input: s = "2*"
	 * 
	 * Output: 15
	 * 
	 * Explanation: The encoded message can represent any of the encoded messages
	 * "21", "22", "23", "24", "25", "26", "27", "28", or "29". "21", "22", "23",
	 * "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29"
	 * only have 1 way. Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15
	 * ways to decode "2*".
	 * 
	 */
	public static int numDecodings2(String s) {
		int[] dp = new int[s.length() + 1];
		Arrays.fill(dp, 1);
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '*') {
				dp[i] = 9;
			} else if (c == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[1];
			}
			if (i + 1 < s.length()) {
				if (s.charAt(i + 1) == '*') {
					if (c == '1') {
						dp[i] = 9 + dp[i+1];
					} else if (c == '2') {
						dp[i] = 6 + dp[i+1];
					}
				} else {
					int val = Integer.valueOf(s.substring(i, i+2));
					if (val >= 10 && val <= 26 && String.valueOf(val).length() == 2) {
						dp[i] += dp[2];
					}
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
//		System.out.println(numDecodings("121"));
		System.out.println(numDecodings("10"));
		System.out.println(numDecodings2("1*"));
		System.out.println(numDecodings2("2*"));
	}
}
