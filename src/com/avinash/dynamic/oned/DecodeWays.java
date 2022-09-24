package com.avinash.dynamic.oned;

import java.util.Arrays;

public class DecodeWays {
	
	public static int numDecoding(String s) {
		int length = s.length();
		int dp[]  = new int[length + 1];
		Arrays.fill(dp, 1);
		char[] charArray = s.toCharArray();
		for (int i = length - 1; i >= 0; i --) {
			if (charArray[i] == '0') 
				dp[i] = 0;
			else 
				dp[i] = dp[i + 1];
			if ( i + 1 < length
					&& (charArray[i + 1] == '1' ||
					(charArray[i] == '2' && Integer.parseInt(charArray[i + 1] + "" ) >= 0  || Integer.parseInt(charArray[i + 1] + "" ) < 7   ))) {
				dp[i] += dp[i + 2];
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		System.out.println(numDecoding("121"));
	}
}
