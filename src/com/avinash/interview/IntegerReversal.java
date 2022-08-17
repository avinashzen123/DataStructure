package com.avinash.interview;

public class IntegerReversal {
	public static int reverseInt(int i) {
		int result = 0;
		while (i != 0) {
			result = result * 10 + (i % 10);
			i = i / 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Reverse Integer : " + reverseInt(1234));
	}
}
