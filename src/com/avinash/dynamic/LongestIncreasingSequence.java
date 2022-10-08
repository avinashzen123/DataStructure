package com.avinash.dynamic;

import java.util.Arrays;

public class LongestIncreasingSequence {
    
    public static int[] lis(int[] array) {
        int[] seq = new int[array.length];
        Arrays.fill(seq, -1);
        int maxIdx = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    seq[i] = j;
                }
            }
            maxIdx = array[maxIdx] < array[i] ? i : maxIdx;
        }
        System.out.println(Arrays.toString(seq));
        System.out.println(maxIdx);
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 7, 11, 8, 10, 13, 16};
        lis(array);
        lis(new int[]{5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35});
    }
}
