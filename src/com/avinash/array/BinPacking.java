package com.avinash.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
class Bin {
	private final int id;
	private final int capcity; // How many units we can store in underlying bin
	private int actualSize; // Actual amount of item we already stored in bin
	private List<Integer> items = new ArrayList<>();

	public boolean put(Integer item) {
		if (actualSize + item > capcity)
			return false;// Item does not fit into bin
		actualSize += item;
		return items.add(item);
	}
}

@Data
class FirstFitDecreasingAlgorithm {
	private List<Bin> bins;
	private List<Integer> items;
	private int binCapacity;
	private int binCounter = 1;

	public FirstFitDecreasingAlgorithm(List<Integer> items, int binCapacity) {
		this.binCapacity = binCapacity;
		this.items = items;
		this.bins = new ArrayList<>(items.size());
	}

	public void showResults() {
		this.bins.stream().forEach(System.out::println);
	}

	/**
	 * Reverse bins in reverse, we will try to fit in small value first. Initialise
	 * variable @currentBin to 0 while add an Bin in variable @bins So size of @bins
	 * is 1 while currently @currentBin is 0 in fist iteration because
	 * conditions @currentBin == @bins.size() is false. try adding bin to last bin
	 * in @bins, fill last bin till it has space. If not increase @currentBin so
	 * that condition @currentBin == @bins.size() and we add one one element in
	 * list @bins then we will keep adding bin in last inserted bin in @bins
	 */
	public void solve() {
		Collections.sort(items, Collections.reverseOrder());
		if (items.get(0) > binCapacity) {
			System.out.println("No feasible solution");
			return;
		}
		bins.add(new Bin(binCounter, binCapacity));
		for (Integer item : items) {
			boolean isOk = false;
			int currentBin = 0;
			while (!isOk) {
				if (currentBin == bins.size()) {
					Bin newBin = new Bin(++binCounter, binCapacity);
					newBin.put(item);
					bins.add(newBin);
					isOk = true;
				} else if (bins.get(currentBin).put(item)) {
					isOk = true;
				} else {
					currentBin++;
				}
			}
		}
	}
}

public class BinPacking {
	public static void main(String[] args) {
//		List<Integer> items = Arrays.asList(5, 5, 5);
//		int binCapacity = 5;
//		FirstFitDecreasingAlgorithm algorithm = new FirstFitDecreasingAlgorithm(items, binCapacity);
//		algorithm.solve();
//		algorithm.showResults();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		System.out.println(list.get(list.size() - 1));
	}
}
