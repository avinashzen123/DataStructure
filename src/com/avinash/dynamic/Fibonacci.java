package com.avinash.dynamic;

import java.util.Arrays;

class Recursive {
    private int iterationCount = 0;
    private int number = 0;
    private int[] dp;
    public Recursive(int n) {
        this.dp = new int[n + 1];
        Arrays.fill(this.dp, -1);
        this.number = fibonacciNumber(n);
        System.out.println(this.number);
    }
    private int fibonacciNumber(int n) {
        this.iterationCount ++;
        if (n == 1 || n == 2) return 1;
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    public int getCount() {
        return this.iterationCount;
    }
}

class DynamicProgrammingTopDown {
    private int dp[];
    private int iterationCount = 0;
    private int number = 0;
    public DynamicProgrammingTopDown(int n) {
        this.dp = new int[n + 1];
        Arrays.fill(dp, -1);
        this.number = fibonacciNumber(n);
        System.out.println(this.number);
    }
    private int fibonacciNumber(int n) {
        this.iterationCount ++;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = fibonacciNumber(n-1) + fibonacciNumber(n-2);
        return dp[n];
    }
    public int getCount() {
        return this.iterationCount;
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Recursive(30).getCount());
        System.out.println(new DynamicProgrammingTopDown(30).getCount());
    }
}
