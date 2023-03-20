package com.avinash.interview;

import java.util.Arrays;

// https://leetcode.com/problems/next-closest-time/description/
/**
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Input: time = "19:34" Output: "19:39" Explanation: The next closest time
 * choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It
 * is not 19:33, because this occurs 23 hours and 59 minutes later
 * 
 */
// Does not considers if new time crosses limit eg. 23:59
public class NextClosestTime {
	public String nextClosestTime(String time) {
		char[] result = time.toCharArray();
		char[] digits = new char[] { result[0], result[1], result[3], result[4] };
		Arrays.sort(digits);
		result[4] = findNext(result[4], (char) ('9' + 1), digits);
		if (result[4] > time.charAt(4))
			return String.valueOf(result);

		result[3] = findNext(result[3], (char) ('9' + 1), digits);
		if (result[3] > time.charAt(3))
			return String.valueOf(result);

		result[1] = findNext(result[1], (char) ('9' + 1), digits);
		if (result[1] > time.charAt(1))
			return String.valueOf(result);

		result[0] = findNext(result[0], (char) ('9' + 1), digits);
		return String.valueOf(result);

	}

	private char findNext(char current, char upperLimit, char[] digits) {
		if (current == upperLimit)
			return digits[0];
		int pos = Arrays.binarySearch(digits, current) + 1;
		while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) {
			pos++;
		}
		return pos == 4 ? digits[0] : digits[pos];
	}

	public static void main(String[] args) {
		NextClosestTime closestTime = new NextClosestTime();
		System.out.println(closestTime.nextClosestTime("19:34"));
		System.out.println(closestTime.nextClosestTime("23:59"));
	}
}
