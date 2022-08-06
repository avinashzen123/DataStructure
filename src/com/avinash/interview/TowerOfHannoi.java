package com.avinash.interview;

public class TowerOfHannoi {

	public void towerOfHannoi(int diskNumber, char source, char middle, char dest) {
		if (diskNumber == 0) {
			System.out.println("Place " + diskNumber + " from " + source + " to "+ dest);
			return;
		}
		towerOfHannoi(diskNumber - 1, source, dest, middle);
		System.out.println("Place " + diskNumber + " from " + source + " to " + dest);
		towerOfHannoi(diskNumber - 1, middle, source, dest);
	}
	
	public static void main(String[] args) {
		TowerOfHannoi hannoi = new TowerOfHannoi();
		hannoi.towerOfHannoi(2, 'a', 'b', 'c');
	}
}
