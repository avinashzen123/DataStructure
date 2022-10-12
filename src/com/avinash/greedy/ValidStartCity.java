package com.avinash.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

import lombok.ToString;

public class ValidStartCity {

	@ToString
	private static class CityDist implements Comparable<CityDist> {
		public int distance;
		public int fuel;
		public int index;
		public int mpg;

		public CityDist(int index, int distance, int fuel, int mpg) {
			this.index = index;
			this.distance = distance;
			this.fuel = fuel;
			this.mpg = mpg;
		}

		public int compareTo(CityDist o) {
			int oRemFuel = o.fuel * o.mpg - o.distance;
			int remFuel = this.fuel * this.mpg - this.distance;
			if (oRemFuel > remFuel) {
				return 1;
			} else if (oRemFuel < remFuel) {
				return -1;
			} else {
				return 1;
			}
//			return (o.distance - o.fuel * 26) - (this.distance - this.fuel * 26) ;
//			if (this.fuel > o.fuel) {
//				return -1;
//			} else if (this.fuel < o.fuel) {
//				return 1;
//			} else if (this.distance < o.distance) {
//				return -1;
//			} else {
//				return 1;
//			}
		}

	}

	// Not working for all test cases
	public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
		// Write your code here.
		PriorityQueue<CityDist> queue = new PriorityQueue<CityDist>();
		for (int i = 0; i < distances.length; i++) {
			queue.add(new CityDist(i, distances[i], fuel[i], mpg));
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

	//Working solution
	public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
		if (Arrays.stream(distances).sum() > Arrays.stream(fuel).map(i -> i * mpg).sum()) {
			return -1;
		}
		int total = 0;
		int start = 0;
		for (int i = 0; i < distances.length; i++) {
			total += ((fuel[i] * mpg) - distances[i]);
			if (total < 0) {
				total = 0;
				start = i + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] distances = { 15, 20, 25, 30, 35, 5 };
		int[] fuel = { 0, 3, 0, 0, 1, 1 };
		int mpg = 26;
		System.out.println(validStartingCity1(distances, fuel, mpg));
	}

}
