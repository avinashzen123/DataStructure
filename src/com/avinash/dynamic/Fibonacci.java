package com.avinash.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static int fibonacciRecursion(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}

	// Top down approach : Memoization
	public static int fibonacciMemoization(int n, Map<Integer, Integer> table) {
		if (!table.containsKey(n)) {
			table.put(n, fibonacciMemoization(n - 1, table) + fibonacciMemoization(n - 2, table));
		}
		// O(1)
		return table.get(n);
	}

	//Bottom up approach : Tabulation
	public static int fibonacciTabulation(int n, Map<Integer, Integer> table) {
		for (int i = 2; i <= n; i++) {
			table.put(i, table.get(i-1) + table.get(i - 2));
		}
		return table.get(n);
	}
	
	public static int fibonacciDynamicProg(int n ) {
		if (n <=1) return 1;
		int[] fib = new int[n+1];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacciRecursion(8));
		HashMap<Integer, Integer> table = new HashMap<>();
		table.put(0, 1);
		table.put(1, 1);
		System.out.println(fibonacciMemoization(8, table));
		table = new HashMap<>();
		table.put(0, 1);
		table.put(1, 1);
		System.out.println(fibonacciTabulation(8, table));
		
		System.out.println(fibonacciDynamicProg(8));

	}
}
