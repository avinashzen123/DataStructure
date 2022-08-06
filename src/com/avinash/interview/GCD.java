package com.avinash.interview;

public class GCD {

	public static int gcd(int i, int j ) {
		if (i  % j == 0) {
			return j;
		}		
		return gcd(j , i % j);
	}
	
	public static int gcd_iteration(int i, int j) {
		int temp = 0;
		
		while (j != 0) {
			temp = j;
			j = i % j;
			i = temp;
		}
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(21, 11));
		System.out.println(gcd_iteration(45, 10));
	}
}
