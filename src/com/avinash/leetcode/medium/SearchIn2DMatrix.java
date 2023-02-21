package com.avinash.leetcode.medium;

// https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/127690/search-a-2d-matrix-ii/
public class SearchIn2DMatrix {


    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix.length - 1 : matrix[0].length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if (!vertical) {
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

	/*
	 * 
	 * We can iterate over the matrix diagonals, we can maintain an invariant that
	 * the slice of the row and column beginning at the current row (row, col) pair
	 * is sorted Therefore we can always binary search these row and column slices
	 * for target. We can proceed in logical fashion, iterating over the diagonals,
	 * binary searching the rows and the columns until we either run out of the
	 * diagonals, binary searching the rows and columns until we either run out of
	 * diagonals, binary searching the rows and columns (meaning we can return
	 * false) or find target (meaning we can return true).
	 * 
	 * BinarySearch function works just like normal binary search but is made ugly
	 * be need to search both rows and columns in 2D array.
	 * 
	 * Time complexity O(log(n!))
	 * 
	 * The asymptotically-largest amount of work performed is in the main loop,
	 * which runs for min(m,n)min(m, n)min(m,n) iterations, where m denotes the
	 * number of rows and n denotes the number of columns.
	 * 
	 * On each iteration, we perform two binary searches on array slices of length
	 * m−im-im−i and n−in-in−i. Therefore, each iteration of the loop runs in
	 * O(log⁡(m−i)+log⁡(n−i))\mathcal{O}(\log(m-i)+\log(n-i))O(log(m−i)+log(n−i))
	 * time, where iii denotes the current iteration. We can simplify this to
	 * O(2⋅log⁡(n−i))=O(log⁡(n−i))\mathcal{O}(2\cdot
	 * \log(n-i))=\mathcal{O}(\log(n-i))O(2⋅log(n−i))=O(log(n−i)) by seeing that, in
	 * the worst case, n≈mn\approx mn≈m. To see why, consider what happens when n≪mn
	 * \ll mn≪m (without loss of generality); nnn will dominate mmm in the
	 * asymptotic analysis. By summing the runtimes of all iterations, we get the
	 * following expression
	 * 
	 * https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/127690/search-a-2d-matrix-ii/
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int shorterDim = Math.min(matrix.length, matrix[0].length);
		for (int i = 0; i < shorterDim; i++) {
			boolean verticalFound = binarySearch(matrix, target, i, true);
			boolean horizontalFound = binarySearch(matrix, target, i, false);
			if (verticalFound || horizontalFound) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Time complexity O(n + m)
	 */
	public boolean searchMatrixIterative(int[][] matrix, int target) {
		int row = matrix.length - 1;
		int col = 0;
		while(row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target) {
				row--;
			} else if (matrix[row][col] < target) {
				col++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(new int[][] {{-1, 3}},-1));
	}
}
