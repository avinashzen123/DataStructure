package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/count-vowels-permutation/    
// https://www.youtube.com/watch?v=VUVpTZVa7Ls
public class CountVowelPermutation {
	public static int countVowelPermutation(int n) {
        long[][] dpTable = new long[n+1][5];
        dpTable[1] = new long[]{1,1,1,1,1,};
        int a = 0, e = 1, i = 2, o = 3, u = 4;
        double mod = Math.pow(10, 9) + 7;
        for (int j= 2; j <= n; j++) {
            dpTable[j] = new long[]{0,0,0,0,0};
            dpTable[j][a] = (int)((dpTable[j-1][e] + dpTable[j-1][i] + dpTable[j-1][u]) % mod);
            dpTable[j][e] = (int)((dpTable[j-1][a] + dpTable[j-1][i]) % mod);
            dpTable[j][i] = (int)((dpTable[j-1][e] + dpTable[j-1][o]) % mod);
            dpTable[j][o] = (int)(dpTable[j-1][i]);
            dpTable[j][u] = (int)((dpTable[j-1][o] + dpTable[j-1][i]) % mod);
        }
        Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
//        return Arrays.asList(dpTable[n]).stream().reduce(0, Integer::sum);
        return (int)Arrays.stream(dpTable[n]).reduce(0, Long::sum);
    }
	
	public static void main(String[] args) {
		System.out.println(Double.MAX_VALUE);
		System.out.println(countVowelPermutation(5));
	}
}
