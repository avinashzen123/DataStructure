package com.avinash.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
public class NumberOfSameConsecutiveDiff {
    public static int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n-1, k, result);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    

    private static void dfs(int i, int n, int k, List<Integer> result) {
        if (n == 0) {
            result.add(i);
            return;
        }
        int prevInt = i % 10;
        if (prevInt >= k ) {
            dfs(i * 10 + (prevInt - k), n -1, k, result);
        }  
        if (k > 0 && prevInt + k < 10) {
            dfs(i * 10  + prevInt + k, n - 1, k, result);
        }
    }

    public static void main(String[] args) {
        int[] result = numsSameConsecDiff(2, 1);
        System.out.println(Arrays.toString(result));
    }
}