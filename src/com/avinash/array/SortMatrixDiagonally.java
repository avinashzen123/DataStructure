package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/sort-the-matrix-diagonally/
public class SortMatrixDiagonally {

	public static void main(String[] args)

	{
		int[][] matrix = { 
				{ 11, 25, 66, 1, 69, 7 }, 
				{ 23, 55, 17, 45, 15, 52 }, 
				{ 75, 31, 36, 44, 58, 8 },
				{ 22, 27, 33, 25, 68, 4 }, 
				{ 84, 28, 14, 11, 5, 50 } 
				};
		
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
		for (int i = 0; i < matrix.length ; i++) {
			int col = 0;
			LinkedList<Integer> temp = new LinkedList<>();
			for (int row = i; row < matrix.length; row++) {
				temp.add(matrix[row][col++]);
			}
			col = 0;
			Collections.sort(temp);
			System.out.println(temp);
			for (int row = i; row < matrix.length; row++) {
				matrix[row][col++] = temp.poll();
			}			
		}
		for (int i = 0; i < matrix[0].length; i++) {
			
		}
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
		System.out.println(Character.isAlphabetic("A".charAt(0)));
	}

}
