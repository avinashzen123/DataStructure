package com.avinash.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/brick-wall/editorial/
public class BrickWall {

	static int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		System.out.println(map);
		int res = wall.size();
		for (int key : map.keySet()) {
			res = Math.min(res, wall.size() - map.get(key));
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> wall = new ArrayList<>();
		wall.add(List.of(1,2,2,1));
		wall.add( List.of(3,1,2));
		wall.add(List.of(1, 3, 2));
		wall.add(List.of(2, 4));
		wall.add(List.of(3, 1, 2));
		wall.add(List.of(1, 3, 1, 1));
		System.out.println(leastBricks(wall));
	}
}
