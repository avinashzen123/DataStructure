package com.avinash.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Strobogrammatic1 {

	// https://leetcode.com/problems/strobogrammatic-number/

	// Given a string num which represents an integer,return true if num is a
	// strobogrammatic number.
	//
	// A strobogrammatic number is a number that looks the same when rotated 180
	// degrees(looked at upside down).
	public static boolean isStrobogrammatic(String num) {
		StringBuffer strBuff = new StringBuffer();
		for (int index = num.length() - 1; index >= 0; index--) {
			char curChar = num.charAt(index);
			if (curChar == '0' || curChar == '1' || curChar == '8') {
				strBuff.append(curChar);
			} else if (curChar == '6') {
				strBuff.append('9');
			} else if (curChar == '9') {
				strBuff.append('6');
			} else {
				return false;
			}
		}
		return num.equals(strBuff.toString());
	}

	// https://leetcode.com/problems/strobogrammatic-number-ii/solutions/1736129/strobogrammatic-number-ii/
	public static class GenerateStrobogrammaticRecursive {
		public static char[][] reversiblePairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

		/*
		 * Time complexity : N * 5 ^ ((n/2) + 1)
		 */
		public static List<String> generateStroboNumbers(int n, int finalLength) {
			if (n == 0) {
				return new ArrayList<>(List.of(""));
			}
			if (n == 1)
				return new ArrayList<>(List.of("0", "1", "8"));
			
			List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
			List<String> curStroboNums = new ArrayList<>();
			
			for (String prevStroboNum : prevStroboNums) {
				for (char[] pair : reversiblePairs) {
					if (pair[0] != '0' || n != finalLength) {
						curStroboNums.add(pair[0] + prevStroboNum + pair[1]);
					}
				}
			}
	        return curStroboNums;
		}
		public static List<String> findStrobogrammatic(int n) {
	        return generateStroboNumbers(n, n);
	    }
	}
	
	public static class GenerateStrobogrammaticIterative {
		public static char[][] reversiblePairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
		/*
		 * Time complexity : N * 5 ^ ((n/2) + 1)
		 */
		public static List<String> findStrobogrammatic(int n) {
			Queue<String> queue = new LinkedList<String>();
			int currStringsLength;
			if (n % 2 == 0) {
				currStringsLength = 0;
				queue.add("");
			} else {
				currStringsLength = 1;
				queue.add("0");
				queue.add("1");
				queue.add("8");
			}
			
			while(currStringsLength < n) {
				currStringsLength += 2;
				for (int i = queue.size(); i > 0; i--) {
					String number = queue.poll();
					for (char[] pair : reversiblePairs) {
						if (currStringsLength != n || pair[0] != '0') {
							queue.add(pair[0] + number + pair[1]);
						}
					}
				}
			}
			List<String> stroboNums = new ArrayList<>();
			while(!queue.isEmpty()) {
				stroboNums.add(queue.poll());
			}
			return stroboNums;
		}
	}

	public static class StrobogrammaticCount {
		public static char[][] reversiblePairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
		
		public static int strobogrammaticInRange(String low, String high) {
	        List<String> list = new ArrayList<>();
	        for (int index = low.length() + 1 ; index < high.length(); index++) {
	        	list.addAll(findStrobogramatic(index));
	        }
	        List<String> lowList = findStrobogramatic(low.length()).stream().filter(i -> i.compareTo(low) > 0).collect(Collectors.toList());
			list.addAll(lowList);
	        List<String> highList = findStrobogramatic(high.length()).stream().filter(i -> i.compareTo(high) < 0).collect(Collectors.toList());
			list.addAll(highList);
			return list.size();
	    }
		
		public static List<String> findStrobogramatic(int n) {
			Queue<String> queue = new LinkedList<>();
			int currStrLength = 0;
			if (n % 2 == 0) {
				queue.add("");
			} else {
				currStrLength = 1;
				queue.add("0");
				queue.add("1");
				queue.add("8");
			}
			while(currStrLength < n) {
				currStrLength += 2;
				for (int index = queue.size(); index > 0; index--) {
					String curNumber = queue.poll();
					for (char[] pair : reversiblePairs) {
						if (currStrLength != n || pair[0] != '0') {
							queue.add(pair[0] + curNumber + pair[1]);
						}
					}
				}
			}
			return queue.stream().collect(Collectors.toList());
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(isStrobogrammatic("69"));
//		System.out.println(GenerateStrobogrammaticRecursive.findStrobogrammatic(4));
		System.out.print(GenerateStrobogrammaticIterative.findStrobogrammatic(2));
		System.out.print(" ");
		System.out.print(GenerateStrobogrammaticIterative.findStrobogrammatic(3));
		System.out.println();
//		System.out.println(StrobogrammaticCount.strobogrammaticInRange("50", "5000"));
		System.out.println(StrobogrammaticCount.strobogrammaticInRange("0", "0"));
		System.out.println("1".compareTo("0"));
		System.out.println("0".compareTo("1"));
	}
}
