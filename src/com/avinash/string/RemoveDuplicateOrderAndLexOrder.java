package com.avinash.string;

import java.util.Stack;

public class RemoveDuplicateOrderAndLexOrder {

    // https://leetcode.com/problems/remove-duplicate-letters/
    public static String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] frequency = new int[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            frequency[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && frequency[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            visited[c - 'a'] = true;
            stack.push(c);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
