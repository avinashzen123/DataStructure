package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/description/

public class PascalTraingleII {
	static class BurtgeForce {
		private int getNum(int row, int col) {
			if (row == 0 || col == 0 || row == col) {
				return 1;
			}
			return getNum(row - 1, col - 1) + getNum(row - 1, col);
		}

		public List<Integer> getRow(int rowIndex) {
			List<Integer> ans = new ArrayList<>();
			for (int i = 0; i <= rowIndex; i++) {
				ans.add(getNum(rowIndex, 1));
			}
			return ans;
		}

	}

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = List.of(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            prevRow = currRow;
        }
        return prevRow;
    }
    
    public static void main(String[] args) {
		System.out.println(new PascalTraingleII().getRow(3));
	}
}
