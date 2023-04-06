package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/description/
/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * Input: asteroids = [5,10,-5]
 * 
 * Output: [5,10]
 * 
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never
 * collide.
 * 
 * Input: asteroids = [8,-8]
 * 
 * Output: []
 * 
 * Explanation: The 8 and -8 collide exploding each other.
 *
 */
public class AstroidCollision {
	static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int ast : asteroids) {
			if (ast > 0 || stack.isEmpty()) {
				stack.push(ast);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
					stack.pop();
				}
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(ast);
				}
				if (!stack.isEmpty() && stack.peek() == Math.abs(ast)) {
					stack.pop();
				}
			}
		}
		return stack.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] astroidCollision = AstroidCollision.asteroidCollision(new int[] { 5, 10, -5 });
		System.out.println(Arrays.toString(astroidCollision));
		System.out.println(Arrays.toString(AstroidCollision.asteroidCollision(new int[] {-2,-1,1,2})));

		System.out.println(Arrays.toString(AstroidCollision.asteroidCollision(new int[] { 8, -8 })));
	}
}
