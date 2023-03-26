package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/car-fleet-ii/description/
// InComplete not working for all test cases
public class CarFleetII {
	public double[] getCollision(int[][] cars) {
		int n = cars.length;
		double[] res = new double[n];
		Arrays.fill(res, -1.0);
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int[] c1 = cars[i];
			while(!stack.isEmpty()) {
				int j = stack.peek();
				int[] c2 = cars[j];
				if (c1[1] > c2[1] && (res[j] == -1.0 || catchTime(cars, i, j) <= res[j])) {
					res[i] = catchTime(cars, i, j);
					break;
				}
				stack.pop();
			}
			stack.push(i);
		}
		return res;
	}
	private double catchTime(int[][] cars, int i, int j) {
		int dist = cars[j][0] - cars[i][0];
		int v = cars[i][1] - cars[j][1];
		return (double)dist/v;
	}
	
	
	public static double[] getCollision1(int[][] cars) {
		double[] result = new double[cars.length];
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(result, -1);
		
		for (int i = cars.length - 1; i >= 0; i--) {
			int currPos = cars[i][0];
			int currSpeed = cars[i][1];
			
			while(!stack.isEmpty()) {
				int topIndex = stack.peek();
				int topPos = cars[topIndex][0];
				int topSpeed = cars[topIndex][1];
				
				if (currSpeed <= topSpeed) {
					stack.pop();
					continue;
				}
				double collisionTime = (double)(topPos - currPos)/(currSpeed - topSpeed);
				if (collisionTime < result[topIndex] || result[topIndex] == -1) {
					result[i] = collisionTime;
					break;
				}
				stack.pop();
			}
			stack.push(i);
		}
		return result;
		/*
		 * 
		 */
//		double[] result = new double[cars.length];
//        Arrays.fill(result, -1);
//        Stack<Integer> stack = new Stack<>();
//        for (int i = cars.length - 1; i >= 0; i--) {
//            int curPosition = cars[i][0];
//            int curSpeed = cars[i][1];
//
//            while(!stack.isEmpty()) {
//                int topIndex = stack.peek();
//                int topPosition = cars[topIndex][0];
//                int topSpeed = cars[topIndex][1];
//                
//                if(curSpeed < topSpeed) {
//                    stack.pop();
//                    continue;
//                }
//
//                double collisionTime = (topPosition - curPosition)/(curSpeed -topSpeed);
//                if (collisionTime < result[topIndex] || result[topIndex] == -1) {
//                    result[topIndex] = collisionTime;
//                    break;
//                }
//                stack.pop();
//            }
//            stack.push(i);
//        }
//        return result;
	}
	
	public static void main(String[] args) {
		int[][] cars = {{1,2},{2,1},{4,3},{7,2}};
//		double[] collisions = new CarFleetII().getCollision(cars);
		double[] collisions = getCollision1(cars);
		System.out.println(Arrays.toString(collisions));
	}
}
