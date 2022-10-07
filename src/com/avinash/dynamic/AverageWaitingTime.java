package com.avinash.dynamic;

public class AverageWaitingTime {

	public static double averageWaitingTime(int[][] customers) {
		int[] servingTime = new int[customers.length];
		servingTime[0] = customers[0][0] + customers[0][1];
		for (int i = 1; i < customers.length; i++) {
			servingTime[i] = Math.max(servingTime[i - 1], customers[i][0]) + customers[i][1];
		}
		for (int i = 0; i < customers.length; i++) {
			if (servingTime[i] < customers[i][0]) {
				servingTime[i] = customers[i][1];
			} else {
				servingTime[i] = Math.abs(servingTime[i] - customers[i][0]);				
			}
		}
		int totalWaitingTime = 0;
		for (int i = 0; i < customers.length; i++) {
			totalWaitingTime += servingTime[i];
		}
		System.out.println(totalWaitingTime);
		return (double)totalWaitingTime / (double)customers.length;
	}
	
	public static void main(String[] args) {
		int[][] data = {{5,2},{5,4},{10,3},{20,1}};
		System.out.println(averageWaitingTime(data));
		
		int[][] data1 = {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
		System.out.println(averageWaitingTime(data1));
		int[][] data2 = {{1,2},{2,5},{4,3}};
		System.out.println(averageWaitingTime(data2));
	}
}
