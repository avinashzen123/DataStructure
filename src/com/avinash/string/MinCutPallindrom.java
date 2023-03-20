package com.avinash.string;

// https://leetcode.com/problems/palindrome-partitioning-ii/
public class MinCutPallindrom {
	
	static class BackTracking {
		/*
		 * Time complexity : O(N ^ 2 * N)
		 */
		public static int minCut(String s) {
			return findMinCut(s, 0, s.length()- 1, s.length() - 1);
		}

		private static int findMinCut(String s, int start, int end, int minCut) {
			if (start == end || isPallindrom(s, start, end)) {
				return 0;
			}
			for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex ++) {
				if (isPallindrom(s, start, currentEndIndex)) {
					minCut = Math.min(minCut, 1 + findMinCut(s, currentEndIndex + 1, end, minCut));
				}
			}
			return minCut;
		}
		private static boolean isPallindrom(String s, int start, int end) {
			while(start < end) {
				if (s.charAt(start++) != s.charAt(end--)) return false;
			}
			return true;
		}
	}
	
	
	
	static class DynamicProgramming {
		/*
		 * Time Complexity : O(N^2 * N)
		 */
		private Integer memoCuts[];
		private Boolean memoPalindrome[][];
		
		public int minCut(String s) {
	        memoCuts = new Integer[s.length()];
	        memoPalindrome = new Boolean[s.length()][s.length()];
	        return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
	    }

	    private int findMinimumCut(String s, int start, int end, int minimumCut) {
	        // base case
	        if (start == end || isPalindrome(s, start, end)) {
	            return 0;
	        }
	        // check for results in memoCuts
	        if (memoCuts[start] != null) {
	            return memoCuts[start];
	        }
	        for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
	            if (isPalindrome(s, start, currentEndIndex)) {
	                minimumCut = Math
	                    .min(minimumCut, 1 + findMinimumCut(s, currentEndIndex + 1, end, minimumCut));
	            }
	        }
	        return memoCuts[start] = minimumCut;
	    }

	    private boolean isPalindrome(String s, int start, int end) {
	        if (start >= end) {
	            return true;
	        }
	        // check for results in memoPalindrome
	        if (memoPalindrome[start][end] != null) {
	            return memoPalindrome[start][end];
	        }
	        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
	            && isPalindrome(s, start + 1, end - 1);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(BackTracking.minCut("aab"));
		System.out.println(BackTracking.minCut("leet"));
		
		System.out.println(new DynamicProgramming().minCut("aab"));
	}
}
