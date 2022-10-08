package com.avinash.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * https://www.youtube.com/watch?v=W9SIlE2jhBQ
     * 
     * Index = k / (n - 1)!
     * ans += char(digits[index])
     * Erase used digit (as digits are unique in number)
     * new K = k - fact[n-1] * index
     * If N == 1 add the last digit.
     * 
     * @param n
     * @param k
     * @return
     */
    public static String sequence(int n, int k) {
        StringBuffer buff = new StringBuffer();
        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            factorial *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k--;

        while(true) {
            int index = k%factorial;
            buff.append(numbers.remove(index));
            if (numbers.size() == 0 ) break;
            k %= factorial;
            factorial /= numbers.size();
        }
        return buff.toString();
    }

    public static void main(String[] args) {
        System.out.println(sequence(4, 14));
    }
}
