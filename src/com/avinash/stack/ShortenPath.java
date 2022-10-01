package com.avinash.stack;

import java.util.Arrays;
import java.util.Stack;

public class ShortenPath {

	public static String shortenPath(String path) {
		boolean startsWithSlash = path.charAt(0) == '/';
		String[] split = path.split("/");
		split = Arrays.stream(split).filter(s -> s.length() >0 && !s.equals(".")).toArray(String[]::new);
		if (startsWithSlash) {
			
		}
		
		StringBuffer result = new StringBuffer();
		Stack<String> stack = new Stack<>();
		for (String s : split) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) stack.pop();
			} else if (s.equals(".")) {
				
			} else {
				stack.push(s);
			}
		}
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).length() > 0) {
				result.append("/" + stack.get(i));
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
	}
}
