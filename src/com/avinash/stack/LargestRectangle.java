package com.avinash.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LargestRectangle {

	public static int largestRectangleUnderSkylineRecursion(List<Integer> buildings) {
		int maxArea = 0;
		for (int index = 0; index < buildings.size(); index++) {
			int currHeight = buildings.get(index);
			int furthestLeft = currHeight;
			while (furthestLeft > 0 && buildings.get(furthestLeft - 1) >= currHeight) {
				furthestLeft--;
			}
			int furthesRight = currHeight;
			while (furthesRight < buildings.size() - 1 && buildings.get(furthesRight + 1) >= currHeight) {
				furthesRight++;
			}
			maxArea = Math.max(maxArea, (furthesRight - furthestLeft) * currHeight);
		}
		return maxArea;
	}
	
	public static int largestRectableUnderSkylineStack(List<Integer> buildings) {
		buildings.add(0);
		int maxArea = 0;
		Stack<Integer> pillarIndices = new Stack<>();
		
		for (int index = 0; index < buildings.size(); index++) {
			int height = buildings.get(index);
			while(!pillarIndices.isEmpty() && buildings.get(pillarIndices.peek()) >= height) {
				int pillarHeight = buildings.get(pillarIndices.pop());
				int width = pillarIndices.isEmpty() ? index : index - pillarIndices.peek();
				maxArea = Math.max(maxArea, width * pillarHeight);
			}
			pillarIndices.add(index);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] heights = { 1, 3, 3, 2, 4, 1, 5, 3, 2 };
		System.out.println(
				largestRectableUnderSkylineStack(Arrays.stream(heights).boxed().collect(Collectors.toList())));
	}
}
