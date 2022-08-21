package com.avinash.interview;

import java.util.stream.IntStream;

public class CountCroak {

	public static int minNumberOfFrogs(String source) {
		int m[] = new int[26];
		int dp[] = new int[4];
		int ans = 0;
		int sum = 0;
		String croak = "croak";

		IntStream.range(0, croak.length()).forEach(i -> m[croak.charAt(i) - 'a'] = i);
		for (char c : source.toCharArray()) {
			int i = m[c - 'a'];
			if (i > 0) {
				if (--dp[i - 1] < 0) return -1;
				--sum;
			}
			if (i < 4) {
				++dp[i];
				++sum;
			}
			ans = Math.max(ans, sum);
		}
		if (dp[0] + dp[1] + dp[2] + dp[3] > 0)return -1;
		return ans;
	}

	public static int countCroak(String s) {
		int c = 0, r = 0, o = 0, a = 0;
		int res = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'c') {
				c++;
			} else if (ch == 'r') {
				c--;
				r++;
				if (c < 0)
					return -1;
			} else if (ch == 'o') {
				r--;
				o++;
				if (r < 0)
					return -1;
			} else if (ch == 'a') {
				o--;
				a++;
			}
			if (ch == 'k') {
				a--;
				if (a < 0)
					return -1;
			}
			res = Math.max(res, c + r + o + a);
		}
		if (c + r + o + a > 0)
			return -1;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(minNumberOfFrogs("croakcroak"));
		System.out.println(minNumberOfFrogs("crcoakroak"));
		
		System.out.println(minNumberOfFrogs("croakcrook"));
		System.out.println(minNumberOfFrogs("croakcrook"));
	}
}
