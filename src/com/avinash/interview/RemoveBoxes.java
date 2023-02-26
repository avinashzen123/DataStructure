package com.avinash.interview;

// https://leetcode.com/problems/remove-boxes/description/
public class RemoveBoxes {

	/*
	 * You are given several boxes with different colors represented by different
	 * positive numbers.
	 * 
	 * You may experience several rounds to remove boxes until there is no box left.
	 * Each time you can choose some continuous boxes with the same color (i.e.,
	 * composed of k boxes, k >= 1), remove them and get k * k points.
	 * 
	 * Return the maximum points you can get.
	 * 
	 * Input: boxes = [1,3,2,2,2,3,4,3,1] 
	 * Output: 23 
	 * Explanation: [1, 3, 2, 2, 2, 3, 4, 3, 1] 
	 * 		----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
	 * 		 ----> [1, 3, 3, 3, 1] (1*1=1 points) 
	 * 			----> [1, 1] (3*3=9 points) 
	 * 				----> [] (2*2=4 points)
	 * 
	 */

	public static class BruteForce {
		/*
		 * Time complexity : O(n!)
		 */
		public static int removeBoxes(int[] boxes) {
			if (boxes.length == 0)
				return 0;
			int result = 0;
			for (int index = 0, matchIndex = index + 1; index < boxes.length; index++) {
				while (matchIndex < boxes.length && boxes[index] == boxes[matchIndex]) {
					matchIndex++;
				}
				int[] newBoxes = new int[boxes.length - (matchIndex - index)];
				for (int newBoxIndex = 0, oldBoxesIndex = 0; oldBoxesIndex < boxes.length;) {
					if (oldBoxesIndex == index) {
						oldBoxesIndex = matchIndex;
					}
					if (oldBoxesIndex < boxes.length) {
						newBoxes[newBoxIndex++] = boxes[oldBoxesIndex++];
					}
				}
				result = Math.max(result, removeBoxes(newBoxes) + (matchIndex - index) * (matchIndex - index));
			}
			return result;
		}
	}

	public static void main(String[] args) {
//		System.out.println(BruteForce.removeBoxes(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }));
		System.out.println(BruteForce.removeBoxes(new int[] { 1, 3, 2, 2, 2 }));
	}
}
