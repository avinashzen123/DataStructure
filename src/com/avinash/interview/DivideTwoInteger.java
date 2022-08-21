package com.avinash.interview;

public class DivideTwoInteger {

	public static int divide(int dividend, int divisor) {
		if (dividend <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
		if (divisor == 1 || divisor == -1) return dividend;
		int count = 1;
		int dividend1 = Math.abs(dividend);
		int divisor1 = Math.abs(divisor);
		int sum = divisor1;
		while (dividend1 >= sum) {
			if (sum + sum < dividend) {
				sum += sum;
				count += count;
			} else {
				sum += divisor1;
				count++;
			}
		}
		count--;
		return divisor < 0 && dividend < 0 ? count : divisor < 0 || dividend < 0 ? -1 * count : count;
	}

	public static void main(String[] args) {
		System.out.println(divide(2147483647,2));
	}
}
