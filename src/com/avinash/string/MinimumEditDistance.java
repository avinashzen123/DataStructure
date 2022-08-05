package com.avinash.string;

/**
 *  <a href="https://www.geeksforgeeks.org/edit-distance-dp-5/">Source</a>
 */

public class MinimumEditDistance {
    private static int min(int i, int j, int k) {
        if (i <= j && j <= k) {
            return i;
        }
        if (j <= i && j <= k) {
            return j;
        }
        return k;
    }

    /**
     * Worst case time complexity is O(3^m)
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    private static int usingRecursion(String str1, String str2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return usingRecursion(str1, str2, m - 1, n - 1);
        }
        return 1 + min(
                usingRecursion(str1, str2, m - 1, n),
                usingRecursion(str1, str2, m, n - 1),
                usingRecursion(str1, str2, m - 1, n - 1)
        );
    }

    /**
     * Time Complexity: O(m x n)
     * Auxiliary Space: O(m x n)
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    static int usingDynamicProgramming(String str1, String str2, int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m ; i ++ ) {
            for (int j = 0; j <= n; j++) {
                if (i ==0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 +
                            min(
                                    dp[i][i-1], // Insert
                                    dp[i][j-1],  //Remove
                                    dp[i-1][j-1] // replace
                            );
                }
            }
        }
        return dp[m][n];
    }

    static int reduceSpaceComplexityDP(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        // Create DP array to memoize result of previous computation
        int[][] dp = new int[2][len1+1];

        for (int i = 0; i <= len1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len2; i ++) {
            for (int j = 0; j < len1; j ++) {
                if (j == 0) dp[i%2][j] = j;
                else if (str1.charAt(j -1) == str2.charAt(i - 1)) {
                   dp[i%2][j] = dp[(i-1)%2] [j-1];
                } else {
                    dp[i%2][j] = 1 + min(dp[(i-1) %2][j], dp[i%2][j-1], dp[(i-1)%2][j-1]);
                }
            }
        }
        return dp[len2 %2][len1];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(usingRecursion(str1, str2, str1.length(), str2.length()));
        System.out.println(usingDynamicProgramming(str1, str2, str1.length(), str2.length()));
        System.out.println(reduceSpaceComplexityDP(str1, str2));
    }

}
