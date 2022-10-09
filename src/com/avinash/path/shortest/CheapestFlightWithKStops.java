package com.avinash.path.shortest;

import java.util.Arrays;

public class CheapestFlightWithKStops {
//	https://leetcode.com/problems/cheapest-flights-within-k-stops/

	/*
	 * There are n cities connected by some number of flights. You are given an
	 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
	 * a flight from city fromi to city toi with cost pricei.
	 * 
	 * You are also given three integers src, dst, and k, return the cheapest price
	 * from src to dst with at most k stops. If there is no such route, return -1.
	 * 
	 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
	 * src = 0, dst = 3, k = 1 Output: 700 Explanation: The graph is shown above.
	 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and
	 * has cost 100 + 600 = 700. Note that the path through cities [0,1,2,3] is
	 * cheaper but is invalid because it uses 2 stops.
	 * 
	 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
	 * = 1 Output: 200 Explanation: The graph is shown above. The optimal path with
	 * at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 =
	 * 200.
	 * 
	 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k
	 * = 0 Output: 500 Explanation: The graph is shown above. The optimal path with
	 * no stops from city 0 to 2 is marked in red and has cost 500.
	 * 
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;
		for (int i = 0; i <= k; i++) {
			int[] tempPrice = prices.clone();
			for (int[] flight : flights) {
				int source = flight[0];
				int to = flight[1];
				int price = flight[2];
				if (prices[source] != Integer.MAX_VALUE) {
					if (prices[source] + price < tempPrice[to]) {
						tempPrice[to] = prices[source] + price;
					}
				}
			}
			prices = tempPrice;
		}
		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}
}
