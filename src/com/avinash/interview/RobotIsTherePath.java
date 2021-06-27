package com.avinash.interview;

import java.util.LinkedList;
import java.util.Queue;

class BFSElement {
	int i, j;

	BFSElement(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class RobotIsTherePath {
	static int R = 4, C = 4;
//	BFSElement b;

	static boolean findPath(int M[][]) {

		// 1) Create BFS queue q
		Queue<BFSElement> q = new LinkedList<>();

		// 2)scan the matrix
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {

				// if there exists a cell in the matrix such
				// that its value is 1 then push it to q
				if (M[i][j] == 1) {
					q.add(new BFSElement(i, j));
					break;
				}
			}

		}

		// 3) run BFS algorithm with q.
		while (q.size() != 0) {
			BFSElement x = q.peek();
			q.remove();
			int i = x.i;
			int j = x.j;

			// skipping cells which are not valid.
			// if outside the matrix bounds
			if (i < 0 || i >= R || j < 0 || j >= C)
				continue;

			// if they are walls (value is 0).
			if (M[i][j] == 0)
				continue;

			// 3.1) if in the BFS algorithm process there was a
			// vertex x=(i,j) such that M[i][j] is 2 stop and
			// return true
			if (M[i][j] == 2)
				return true;

			// marking as wall upon successful visitation
			M[i][j] = 0;

			// pushing to queue u=(i,j+1),u=(i,j-1)
			// u=(i+1,j),u=(i-1,j)
			for (int k = -1; k <= 1; k += 2) {
				q.add(new BFSElement(i + k, j));
				q.add(new BFSElement(i, j + k));
			}
		}

		// BFS algorithm terminated without returning true
		// then there was no element M[i][j] which is 2, then
		// return false
		return false;

	}

	// Main Driver code
	public static void main(String[] args) {
		int M[][] = { { 0, 3, 0, 1 }, { 3, 0, 3, 3 }, { 2, 3, 3, 3 }, { 0, 3, 3, 3 } };

		if (findPath(M) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
