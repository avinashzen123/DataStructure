package com.avinash.interview;

import java.util.PriorityQueue;

import lombok.ToString;

public class ValidStartCity {
	
	@ToString
	private static class CityDist implements Comparable<CityDist> {
		public int distance;
		public int fuel;
		public int index;

		public CityDist(int index, int distance, int fuel) {
			this.index = index;
			this.distance = distance;
			this.fuel = fuel;
		}

		public int compareTo(CityDist o) {
			if (this.fuel > o.fuel) {
				return -1;
			} else if (this.fuel < o.fuel) {
				return 1;
			} else if (this.distance < o.distance) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
		// Write your code here.
		PriorityQueue<CityDist> queue = new PriorityQueue<CityDist>();
		for (int i = 0; i < distances.length; i++) {
			queue.add(new CityDist(i, distances[i], fuel[i]));
		}
		int remainingFuel = 0;
		CityDist city = queue.peek();
		while (!queue.isEmpty()) {
			CityDist poll = queue.poll();
			remainingFuel = remainingFuel + poll.fuel * mpg - poll.distance;
			if (remainingFuel < 0) {
				return -1;
			}
		}
		if (remainingFuel >= 0) {
			return city.index;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] distances = { 15, 20, 25, 30, 35, 5 };
		int[] fuel = { 0, 3, 0, 0, 1, 1 };
		int mpg = 26;
		System.out.println(validStartingCity(distances, fuel, mpg));
	}

}
