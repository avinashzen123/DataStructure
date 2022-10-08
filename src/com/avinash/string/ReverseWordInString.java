package com.avinash.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseWordInString {

	public static String reverseWordsInString(String string) {
		Stack<String> stack = new Stack<>();
		String word = "";
		for (char c : string.toCharArray()) {
			if (c == ' ') {
				if (!word.isEmpty()) {
					stack.push(word);
					word = "";
				}
				stack.push(c + "");
			} else {
				word += c;
			}
		}
		if (!word.isEmpty()) {
			stack.push(word);
		}
		StringBuffer buff = new StringBuffer();
		while(!stack.isEmpty()) {
			buff.append(stack.pop());
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWordsInString("Algo expert is best!"));
		Set<Character> s = new HashSet<>();
		s.add('c');
		s.add('a');
	}
}
