package com.avinash.interview;

import java.util.Arrays;
import java.util.Comparator;


// https://leetcode.com/problems/matchsticks-to-square/
// https://www.youtube.com/watch?v=hUe0cUKV-YY
public class MatchStickToSquare {
    public static boolean makesquare(int[] matchsticks) {
        int length = Arrays.stream(matchsticks).sum();
        if (length % 4 != 0) {
            return false;
        }
        Integer[] array = Arrays.stream(matchsticks).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        int[] sides = new int[4];
        return backTrack(array, sides, 0, length/4);
    }

    private static boolean backTrack(Integer[] matchsticks, int[] sides, int index, int length) {
        if (index == matchsticks.length) return true;
        for (int i = 0; i < sides.length; i ++) {
            if (sides[i] + matchsticks[index] <= length) {
                sides[i] = sides[i] + matchsticks[index];
                if (backTrack(matchsticks, sides, index + 1, length)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(makesquare(new int[] {1,1,2,2,2}));
        System.out.println(makesquare(new int[] {3,3,3,3,4}));
    }
}