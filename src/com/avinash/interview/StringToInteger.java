package com.avinash.interview;

import java.util.LinkedList;
import java.util.Queue;

public class StringToInteger {

	public static int myAtoi(String s) {
//		s = s.trim();
		s = " " + s;
		char[] charArray = s.toCharArray();
		int currentNumber = 0;
		char operator = ' ';
		Queue<Integer> queue = new LinkedList<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			try {
				if (currentNumber == 0) {
					currentNumber = Integer.parseInt("" + charArray[i]);
				} else {
					currentNumber = (int) (Integer.parseInt("" + charArray[i]) * Math.pow(10, String.valueOf(currentNumber).length()) + currentNumber);
				}
			} catch (Exception e) {
				if (operator == ' ') {
					operator = charArray[i];					
				} else if (operator == '+' && !queue.isEmpty() && currentNumber > 0) {
					Integer poll = queue.poll();
					queue.add(poll + currentNumber);
					operator = ' ';
				} else if (operator == '-') {
					if (!queue.isEmpty() ) {
						queue.add(queue.poll() * -1);
					} else if( currentNumber > 0) {
						Integer poll = queue.poll();
						queue.add(currentNumber - poll);						
					}
					operator = ' ';
				}
				if (currentNumber > 0) {
					queue.add(currentNumber);
				}
				currentNumber = 0;
			}
		}

		return !queue.isEmpty() ? queue.poll() : currentNumber;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("words and 987"));
	}

}
