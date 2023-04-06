package com.avinash.stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/
public class SimplifyPath {

	static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String part : path.split("/")) {
			if (part.equals(".") || part.isEmpty()) {
				continue;
			} else if (part.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(part);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (String str : stack) {
			builder.append("/");
			builder.append(str);
		}
		return stack.isEmpty() ? "/" : builder.toString();
	}

	public static void main(String[] args) {
		var path = "/home/avinash/";

		System.out.println(simplifyPath(path));
	}
}
