package com.avinash.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter next int, 'done' to stop");
        String line = scanner.next();
        while (!line.equals("done")) {
            heap.insert(Integer.parseInt(line));
            line = scanner.next();
        }
        heap.getHeap().forEach(System.out::println);
        System.out.println("Deleting item");
        heap.poll();
        heap.getHeap().forEach(System.out::println);
        scanner.close();
    }

    public void insert(T data) {
        this.heap.add(data);
        this.shiftUp(this.heap.size() - 1);
    }

    public List<T> getHeap() {
        return this.heap;
    }

    private T poll() {
        final T value = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);
        shiftDown(0);
        return value;
    }

    private void shiftDown(int parentIndex) {
        final int leftIndex = leftIndex(parentIndex);
        if (leftIndex < this.heap.size()) {
            int max = leftIndex;
            final int rightIndex = rightIndex(parentIndex);
            if (rightIndex < this.heap.size() && this.heap.get(max).compareTo(this.heap.get(rightIndex)) < 0) {
                max = rightIndex;
            }
            if (this.heap.get(max).compareTo(this.heap.get(parentIndex)) > 0) {
                swap(max, parentIndex);
                shiftDown(max);
            }
        }
    }

    private void shiftUp(int childIndex) {
        final int parentIndex = parentIndex(childIndex);
        if (this.heap.get(parentIndex).compareTo(this.heap.get(childIndex)) < 0) {
            swap(parentIndex, childIndex);
            shiftUp(parentIndex);
        }
    }

    private int leftIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int rightIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int i, int j) {
        final T temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    }

}
