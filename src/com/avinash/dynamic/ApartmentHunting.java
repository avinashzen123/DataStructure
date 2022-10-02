package com.avinash.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		// Write your code here.
		int[] maxDistancesAtBlocks = new int[blocks.size()];
		Arrays.fill(maxDistancesAtBlocks, Integer.MIN_VALUE);
		for (int fromApt = 0; fromApt < blocks.size(); fromApt++) {
			for (String req : reqs) {
				int closestDistance = Integer.MAX_VALUE;
				for (int toApt = 0; toApt < blocks.size(); toApt++) {
					if (blocks.get(toApt).containsKey(req) && blocks.get(toApt).get(req)) {
						closestDistance = Math.min(closestDistance, Math.abs(fromApt - toApt));
					}
				}
				maxDistancesAtBlocks[fromApt] = Math.max(maxDistancesAtBlocks[fromApt], closestDistance);
			}
		}
		return getIdxAtMinValue(maxDistancesAtBlocks);
	}

	private static int getIdxAtMinValue(int[] array) {
		int indexAtMinValue = 0;
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int currValue = array[i];
			if (currValue < minValue) {
				minValue = currValue;
				indexAtMinValue = i;
			}
		}
		return indexAtMinValue;
	}


	public static void main(String[] args) {
		List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();

		blocks.add(0, new HashMap<String, Boolean>());
		blocks.get(0).put("gym", false);
		blocks.get(0).put("school", true);
		blocks.get(0).put("store", false);

		blocks.add(1, new HashMap<String, Boolean>());
		blocks.get(1).put("gym", true);
		blocks.get(1).put("school", false);
		blocks.get(1).put("store", false);

		blocks.add(2, new HashMap<String, Boolean>());
		blocks.get(2).put("gym", true);
		blocks.get(2).put("school", true);
		blocks.get(2).put("store", false);

		blocks.add(3, new HashMap<String, Boolean>());
		blocks.get(3).put("gym", false);
		blocks.get(3).put("school", true);
		blocks.get(3).put("store", false);

		blocks.add(4, new HashMap<String, Boolean>());
		blocks.get(4).put("gym", false);
		blocks.get(4).put("school", true);
		blocks.get(4).put("store", true);

		String[] reqs = new String[] { "gym", "school", "store" };
		
		System.out.println(apartmentHunting(blocks, reqs));
	}
}
