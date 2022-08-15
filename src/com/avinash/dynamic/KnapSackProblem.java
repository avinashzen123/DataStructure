package com.avinash.dynamic;

public class KnapSackProblem {
	//Total number of items
	private int n;
	//THis is the M capacity of the Knapsack
	private int capacity;
	//Dynamic programming table (2 dimensional array)
	private int[][] s;
	
	private int[] weights;
	private int[] values;
	
	public KnapSackProblem(int n, int capacity, int[] weight, int[] values) {
		this.n = n;
		this.capacity = capacity;
		this.weights = weight;
		this.values = values;
		this.s = new int[n+1][capacity + 1];
	}
	
	
	public void solve() {
		//Initialize
		//Time complexity : O(n * M)
		for (int i = 1; i < n + 1; i++) {
			for (int w = 1; w < capacity + 1; w++) {
				//Whether to take item i or not
				int notTakingItem = s[i-1][w];
				int takingItem = 0;
				if(weights[i] <= w) {
					takingItem = values[i] + s[i-1][w-weights[i]];
				}
				s[i][w] = Math.max(takingItem, notTakingItem);
			}
		}
	}
	
	public void showResult() {
		System.out.println("Total Benifit :" + this.s[n][capacity]);
		for (int i = n, w = capacity; i > 0; i--) {
			if(s[i][w] != 0 && s[i][w] != s[i-1][w]) {
				System.out.println("We take item # " +i);
				w = w - weights[i];
			}
		}
	}
	
	public static void solve(int[] weights, int[] values, int capacity, int numberOfItems) {
		int[][] dpTable = new int[numberOfItems + 1][capacity + 1];
		for (int valIndex = 1; valIndex <= numberOfItems; valIndex++) {
			for (int weight = 1; weight <= capacity; weight++) {
				if (weights[valIndex] <= weight) {
					dpTable[valIndex][weight] = Math.max(dpTable[valIndex - 1][weight],
							values[valIndex] + dpTable[valIndex - 1][weight - weights[valIndex]]);
				} else {
					dpTable[valIndex][weight] = dpTable[valIndex-1][weight];
				}
			}
		}
		System.out.println("Total Benifit :" + dpTable[numberOfItems][capacity]);
		for (int i = numberOfItems, w = capacity; i > 0; i--) {
			if(dpTable[i][w] != 0 && dpTable[i][w] != dpTable[i-1][w]) {
				System.out.println("We take item # " +i);
				w = w - weights[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int numOfItems = 4;
		int capacityOfKnapsack = 7;
		int[] weightOfItems = {0,1,3,4,5};
		int[] profitOfItems = {0,1,4,5,7};
		KnapSackProblem problem = new KnapSackProblem(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
		problem.solve();
		problem.showResult();
		
		System.out.println(problem.solveRecursive(capacityOfKnapsack, weightOfItems, profitOfItems, numOfItems));
		solve(weightOfItems, profitOfItems, capacityOfKnapsack, numOfItems);
	}
	
	public int solveRecursive(int m, int[] w, int[] v, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (w[n-1] > m) {
			return solveRecursive(m, w, v, n-1);
		} else {
			int included = v[n-1] + solveRecursive(m - w[n-1], w, v, n-1);
			int excluded = solveRecursive(m, w, v, n-1);
			return Math.max(included, excluded);
		}
	}
	

}
