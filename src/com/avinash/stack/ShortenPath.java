package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenPath {

	public static String shortenPath(String path) {

		Stack<String> stack = new Stack<>();
		String[] split = Arrays.stream(path.split("/")).filter(s -> s.length() > 0 && !s.equals(".")).toArray(String[]::new);
		if (path.charAt(0) == '/') {
			stack.add("");
		}

		for (String s : split) {
			if (s.equals("..")) {
				if (stack.isEmpty() || stack.peek().equals("..")) { // {Path starts with ..
					stack.push(s);
				} else if (!stack.peek().equals("")) { // Path has empty string remove it
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		if (stack.isEmpty() || (stack.size() == 1 && stack.peek().length() == 0)) {
			return "/";
		}

		return stack.stream().collect(Collectors.joining("/"));
	}

	public static void main(String[] args) {
//		System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
		System.out.println(shortenPath(
				"/../../../this////one/./../../is/../../going/../../to/be/./././../../../just/a/forward/slash/../../../../../.."));
//		System.out.println(shortenPath("/"));
	}
}
