package com.avinash.interview;

import java.util.ArrayList;
import java.util.List;

/*
 * We are given a list of strings wordsDict and two strings word1 
 * and word2 present in this list. Both these strings will always represent 
 * two individual strings in the original list. We need to find the minimum 
 * distance between these two strings in the list, as there could be duplicates.
 */
public class ShortestWordDistance3 {
	private static class ShortestWordDistanceBinarySearch {
		// Not working
		public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
			List<Integer> indices1 = new ArrayList<>();
			List<Integer> indices2 = new ArrayList<>();
			for (int index = 0; index < wordsDict.length; index++) {
				if (wordsDict[index].equals(word1)) {
					indices1.add(index);
				} else if (wordsDict[index].equals(word2)) {
					indices2.add(index);
				}
			}
			int shortestDistance = Integer.MAX_VALUE;
			for (int index : indices1) {
				int x = upperBound(indices2, index);
				if (x != indices2.size()) {
					shortestDistance = Math.min(shortestDistance, indices2.get(x) - index);
				}
				if (x != 0 && indices2.get(x - 1) != index) {
					shortestDistance = Math.min(shortestDistance, index - indices2.get(x - 1));
				}
			}
			return shortestDistance;
		}

		private static int upperBound(List<Integer> indices, int value) {
			int n = indices.size();
			int left = 0;
			int right = n - 1;
			int index = n;
			while(left <= right) {
				int mid = (left + right) / 2;
				if (indices.get(mid) > value) {
					index = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return index;
		}
	}
	
	private static class TwoPointerSolution {
		public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
			int shortestDistance = Integer.MAX_VALUE;
			int prevIndex = -1;
			for (int index = 0; index < wordsDict.length; index++) {
				if (wordsDict[index].equals(word1) || wordsDict[index].equals(word2)) {
					if (prevIndex != -1 && ( !wordsDict[index].equals(wordsDict[prevIndex]) || word1.equals(word2))) {
						shortestDistance = Math.min(shortestDistance, index - prevIndex);
					}
					prevIndex = index;
				}
 			}
			return shortestDistance;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ShortestWordDistanceBinarySearch.shortestWordDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));
		System.out.println(TwoPointerSolution.shortestWordDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));
	}
}
