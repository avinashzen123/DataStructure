package com.avinash.interview;

// https://leetcode.com/problems/power-of-two/solutions/360718/power-of-two/
public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		return (n & (-n)) == n;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));
		System.out.println(isPowerOfTwo(6));
	}
}
