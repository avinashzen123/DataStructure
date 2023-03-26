package com.avinash.array;

import java.util.Arrays;

// https://leetcode.com/problems/find-a-peak-element-ii/description/
/**
 * A peak element in a 2D grid is an element that is strictly greater than all
 * of its adjacent neighbors to the left, right, top, and bottom.
 * 
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal,
 * find any peak element mat[i][j] and return the length 2 array [i,j].
 * 
 * You may assume that the entire matrix is surrounded by an outer perimeter
 * with the value -1 in each cell.
 * 
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 * 
 * Input: mat = [[1,4},{3,2]]
 * 
 * Output: [0,1]
 * 
 * Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both
 * acceptable answers.
 *
 *
 * Input: mat = [[10,20,15},{21,30,14},{7,16,32]]
 * 
 * Output: [1,1]
 * 
 * Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both
 * acceptable answers.
 */
public class PeakElementII {
	public int[] findPeakElement(int[][] mat) {
		int startCol = 0;
        int endCol = mat[0].length - 1;
        while(startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int maxRow = 0;
            for (int row = 0; row < mat.length; row++) {
                maxRow = mat[row][midCol] > mat[maxRow][midCol] ? row : maxRow;
            }
            boolean isLeftMax = midCol > startCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean isRightMax = endCol > midCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            if(!isLeftMax && !isRightMax) {
                return new int[] {maxRow, midCol};
            } else if (isRightMax) {
                startCol = midCol + 1;
            } else {
                endCol = midCol - 1;
            }
        }
        return null;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{10,20,15},{21,30,14},{7,16,32}};
		int[] peakElement = new PeakElementII().findPeakElement(mat);
		System.out.println(Arrays.toString(peakElement));
		int[][] mat1 = {{41,8,2,48,18},{16,15,9,7,44},{48,35,6,38,28},{3,2,14,15,33},{39,36,13,46,42}};
		int[] peakEle = new PeakElementII().findPeakElement(mat1);
		System.out.println(Arrays.toString(peakEle));
		
		int[][] mat2 = {{25,37,23,37,19},{45,19,2,43,26},{18,1,37,44,50}};
		int[] peekEle1 = new PeakElementII().findPeakElement(mat2);
		System.out.println(Arrays.toString(peekEle1));
	}
}
