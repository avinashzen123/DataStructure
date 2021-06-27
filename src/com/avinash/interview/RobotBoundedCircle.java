package com.avinash.interview;

//https://www.youtube.com/watch?v=zPLYQ6H0EBI
public class RobotBoundedCircle {

	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLL"));
	}

	public static boolean isRobotBounded(String instructions) {
//    	int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
		int[][] direction = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

		int i = 0;
		int y = 0;
		int x = 0;
		for (char c : instructions.toCharArray()) {
			if (c == 'L') {
				i = (i + 1) % 4;
			} else if (c == 'R') {
				i = (i + 3) % 4;
			} else {
				x = x + direction[i][0];
				y = y + direction[i][1];
			}
		}
		return x == 0 && y == 0 || i != 0;
	}

}
