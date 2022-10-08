package com.avinash.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {
	/*
	 * https://leetcode.com/problems/partition-labels/
	 * 
	 * You are given a string s. We want to partition the string into as many parts
	 * as possible so that each letter appears in at most one part.
	 * 
	 * Note that the partition is done so that after concatenating all the parts in
	 * order, the resultant string should be s.
	 * 
	 * Return a list of integers representing the size of these parts.
	 * 
	 * Input: s = "ababcbacadefegdehijhklij"
	 * 
	 * Output: [9,7,8]
	 * 
	 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij". This is a
	 * partition so that each letter appears in at most one part. A partition like
	 * "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less
	 * parts.
	 * 
	 * Input: s = "eccbbbbdec"
	 * 
	 * Output: [10]
	 * 
	 */

	public static List<Integer> partitionLabels(String s) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> lastPosition = new HashMap<>();
		for (int index = 0; index < s.length(); index ++) {
			char c = s.charAt(index);
			if (!lastPosition.containsKey(c)) {
				lastPosition.put(c, 0);
			}
			lastPosition.put(c, index);
		}
		int size = 0;
		int end = 0;
		
		for (int index = 0; index < s.length(); index++) {
			char c = s.charAt(index);
			size++;
			end = Math.max(end, lastPosition.get(c));
			if (index == end) {
				result.add(size);
				size = 0;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
}
