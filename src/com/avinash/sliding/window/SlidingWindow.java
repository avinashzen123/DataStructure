package com.avinash.sliding.window;

<<<<<<< HEAD
public class SlidingWindow {

}
=======
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindow {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubString(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // https://leetcode.com/problems/longest-repeating-character-replacement/
    /*
     * You are given a string s and an integer k. You can choose any character of
     * the string and change it to any other uppercase English character. You can
     * perform this operation at most k times.
     * 
     * Return the length of the longest substring containing the same letter you can
     * get after performing the above operations.
     * 
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     */
    public static int characterReplacement(String s, int k) {
        int ans = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            if (right - left - maxFreq + 1 > k) {
                freq[s.charAt(left++) - 'A']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // Permutation in String
    /*
     * https://leetcode.com/problems/permutation-in-string/
     * 
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
     * or false otherwise.
     * 
     * In other words, return true if one of s1's permutations is the substring of
     * s2.
     * 
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     * 
     */
    public static boolean checkInclusion1(String s1, String s2) {
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;
        int j = 0;
        int i = 0;
        for (; j < s1.length(); j++)
            freq[s2.charAt(j) - 'a']--;
        if (Arrays.stream(freq).filter(k -> k != 0).findAny().isEmpty())
            return true;
        while (j < s2.length()) {
            freq[s2.charAt(i++) - 'a']++;
            freq[s2.charAt(j++) - 'a']--;
            if (Arrays.stream(freq).filter(k -> k != 0).findAny().isEmpty())
                return true;
        }
        return false;
    }

    /*
     * https://leetcode.com/problems/minimum-window-substring/
     * 
     * Given two strings s and t of lengths m and n respectively, return the minimum
     * window substring of s such that every character in t (including duplicates)
     * is included in the window. If there is no such substring, return the empty
     * string "".
     * 
     * The testcases will be generated such that the answer is unique.
     * 
     * A substring is a contiguous sequence of characters within the string.
     * 
     * 
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
     * from string t.
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        if (t.equals(s))
            return t;
        Map<Character, Integer> map = new HashMap<>();
        int subStrStart = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int matched = 0;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int subStrEnd = 0; subStrEnd < s.length(); subStrEnd++) {
            char charEnd = s.charAt(subStrEnd);
            if (map.containsKey(charEnd)) {
                map.put(charEnd, map.get(charEnd) - 1);
                if (map.get(charEnd) == 0)
                    matched++;
            }
            while (matched == map.size()) {
                if (minLen > subStrEnd - start + 1) {
                    minLen = subStrEnd - start + 1;
                    subStrStart = start;
                }
                char deleteChar = s.charAt(start++);
                if (map.containsKey(deleteChar)) {
                    if (map.get(deleteChar) == 0)
                        matched--;
                    map.put(deleteChar, map.get(deleteChar) + 1);
                }
            }
        }
        return minLen > 0 && minLen < s.length() + 1 ? s.substring(subStrStart, subStrStart + minLen) : "";
    }

    /*
     * https://leetcode.com/problems/sliding-window-maximum/
     * 
     * You are given an array of integers nums, there is a sliding window of size k
     * which is moving from the very left of the array to the very right. You can
     * only see the k numbers in the window. Each time the sliding window moves
     * right by one position.
     * 
     * Return the max sliding window.
     * 
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position Max
     * --------------- -----
     * [1 3 -1] -3 5 3 6 7 -> 3
     * 1 [3 -1 -3] 5 3 6 7 -> 3
     * 1 3 [-1 -3 5] 3 6 7 -> 5
     * 1 3 -1 [-3 5 3] 6 7 -> 5
     * 1 3 -1 -3 [5 3 6] 7 -> 6
     * 1 3 -1 -3 5 [3 6 7] -> 7
     * 
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int low = 0;
        int high = 0;
        while(high < nums.length) {
            while(!deque.isEmpty() && deque.peekLast() < nums[high]) deque.removeLast();
            deque.add(nums[high]);
            if (high - low + 1 == k) {
                result[low] = deque.getFirst();
                if (nums[low] == deque.getFirst()) {
                    deque.removeFirst();
                }
                low ++;
            }
            high++;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(lengthOfLongestSubString("abbbb"));
        // System.out.println(characterReplacement("AABABBA", 1));
        // System.out.println(checkInclusion1("abn", "dcalbaa"));

        // String s = "ADOBECODEBANC", t = "ABC";
        // System.out.println(minWindow(s, t));
        // System.out.println(minWindow("a", "b"));
        // System.out.println(minWindow("abc", "ac"));

        int[] result = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(result));
    }
}
>>>>>>> 74f9b6c0f89a947c7e8fd71c981d07a057e7afd3
