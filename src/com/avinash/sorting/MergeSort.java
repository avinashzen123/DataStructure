package com.avinash.sorting;

public class MergeSort {
    private final int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public static void main(String args[]) {
        int arr[] = {12, 4, 11, 13, 5, 6, 7};
        MergeSort ob = new MergeSort(arr);
        System.out.println("Given Array");
        ob.printArray();
        ob.sort();
        System.out.println("\nSorted array");
        ob.printArray();
    }

    private void sort() {
        this.sort(0, this.array.length - 1);
    }

    private void sort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            this.merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        int leftSubArray[] = this.createSubArray(middle - low + 1, low);
        int rightSubArray[] = this.createSubArray(high - middle, middle + 1);
        int i = 0, j = 0, k = low;
        while (i < leftSubArray.length && j < rightSubArray.length) {
            this.array[k++] = leftSubArray[i] <= rightSubArray[j] ? leftSubArray[i++] : rightSubArray[j++];
        }
        copyRestOfArray(rightSubArray, j, copyRestOfArray(leftSubArray, i, k));
    }

    private int copyRestOfArray(int[] subArray, int i, int k) {
        while (i < subArray.length) {
            this.array[k++] = subArray[i++];
        }
        return k;
    }

    private int[] createSubArray(int size, int parentStartIndex) {
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.array[parentStartIndex + i];
        }
        return array;
    }

    public void printArray() {
        for (int i = 0; i < this.array.length; ++i)
            System.out.print(this.array[i] + " ");
    }
}
