package com.avinash.interview;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/description/
/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * Input: s = "egg", t = "add" Output: true
 * 
 * Input: s = "foo", t = "bar" Output: false
 */
public class IsomorphicString {
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Character> sourceToTargetMap = new HashMap<>();
		Map<Character, Character> targetToSourceMap = new HashMap<>();

		for (int index = 0; index < s.length(); index++) {
			Character sourceChar = s.charAt(index);
			Character targetChar = t.charAt(index);
			Character sourceRet = sourceToTargetMap.getOrDefault(sourceChar, targetChar);
			if (sourceRet != targetChar)
				return false;
			sourceToTargetMap.put(sourceChar, targetChar);
			Character targetRet = targetToSourceMap.getOrDefault(targetChar, sourceChar);
			if (sourceChar != targetRet)
				return false;
			targetToSourceMap.put(targetChar, sourceChar);
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
	}
}
