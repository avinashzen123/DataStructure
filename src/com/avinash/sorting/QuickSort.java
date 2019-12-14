package com.avinash.sorting;

public class QuickSort {
    private final int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        int array[] = {10, 7, 8, 3, 9, 2, 1, 5};
        QuickSort quickSort = new QuickSort(array);
        quickSort.quickSort();
        quickSort.display();
    }

    public void quickSort() {
        sort(0, this.array.length - 1);
    }

    private void sort(int low, int high) {
        if (low <= high) {
            int pivotIndex = partition(low, high);
            sort(low, pivotIndex - 1);
            sort(pivotIndex + 1, high);
        }
    }
    
    private int findPivot(int low, int high) {
		for (;low < high; low++) {
			if(this.array[low] >= this.array[high]) {
				swap(high, low);
			}
		}
		swap(low, high);
		return low;
	}

    private int partition(int low, int high) {
        int pivot = this.array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (this.array[j] <= pivot) {
                swap(i++, j);
            }
        }
        swap(i, high);
        return i;
    }

    private void swap(int i, int j) {
        int tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }

    public void display() {
        for (Integer value : this.array) {
            System.out.print(value + " ");
        }
    }
}
