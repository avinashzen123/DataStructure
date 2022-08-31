package com.avinash.array;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrics =  {
            {5,1,9,11},
            {2,4,8,10},
            {12,3,6,7},
            {15,14,12,16}
        };
        rotateImage(matrics);
    }

    /**
     * 0,0 => a[0][a[0].length -1]
     * 0,1 => a[1][a[0].length -1]
     * 0,2 => a[2][a[0].length -1]
     * 0,3 => a[3][a[0].length -1]
     * 
     * 0, a[0].length -1 => a[a[0].length -1][a[0].length -1]
     * 1. [a[0].length -1] => a[a[0].length -1][a[0].length -1 -1]
     * 
     * @param matrics
     */
    private static void rotateImage(int[][] matrics) {
        int left = 0;
        int right = matrics.length - 1;
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;
                // Store top left
                int temp = matrics[top][left + i];
                // Swap top left with bottom left
                matrics[top][left + i] = matrics[bottom - i][left];
                // Swap bottom left with bottom right
                matrics[bottom-i][left] = matrics[bottom][right-i];
                // Swap bottom right with top right
                matrics[bottom][right - i] = matrics[top + i][right];
                // Swap top right with saved top left
                matrics[top + i][right] = temp;
            }
            left ++;
            right --;
        }
        Arrays.stream(matrics).map(Arrays::toString).forEach(System.out::println);
    }
}