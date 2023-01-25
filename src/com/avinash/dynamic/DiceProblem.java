package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://cses.fi/problemset/task/1633

Your task is to count the number of ways to construct sum nby throwing a dice one or more 
times. Each throw produces an outcome between 1and 6.

For example, if n=3, there are 4ways:
	• 1+1+1
	• 1+2
	• 2+1
	• 3

Input

The only input line has an integer n.

Output

Print the number of ways modulo 109+7.

Constraints
	• 1≤n≤106

Example

Input:
3

Output:
4
 */
public class DiceProblem {
    public static int numberOfWays(int[] dp, int n) {
        if (n < 0) return 0;
        if (n == 0 ) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = 0;
        IntStream.range(1, 7).forEach(i -> {
            dp[n] += numberOfWays(dp, n-i);
        });
        return dp[n];
    }

    public static void main(String[] args) {
        int sum = 4;
        int dp[] = new int[sum + 1];
        Arrays.fill(dp, -1);
        System.out.println(numberOfWays(dp, sum));
        System.out.println(Arrays.toString(dp));
    }
}
