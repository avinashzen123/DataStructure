package com.avinash.array;

public class FindMinimumInRotatedArray {

	public static int findMin(int[] array) {
		int res = array[0];
		int left = 0; 
		int right = array.length - 1;
		while(left < right) {
			if (array[left] < array[right]) {
				res = Math.min(res, array[left]);
			}
			int middle = (left + right)/2;
			if (array[middle] > array[left]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return res;
	}

	public static int findMin1(int[] array) {
		int res = array[0];
		int localMin = array[0];
		for (int index = 1 ; index < array.length - 1; index++) {
			localMin = Math.min(localMin, array[index]);
			res = Math.min(res, localMin);
		}
		return res;
	}
	
	public static int findMin2(int[] nums) {
		if (nums.length == 1) return nums[0];
		int left = 0, right = nums.length - 1;
		if (nums[right] > nums[0]) {
			return nums[0];
		}
		while(right >= left) {
			int mid = left + (right - left) / 2;
			// if the mid element is greater than its next element then mid + 1 
			// element is the smallest. This point would be the point of change.
			// From higher to lower value.
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			// if mid element is lesser than its previous element then mid 
			// Element is smallest.
			if (nums[mid -1] > nums[mid]) {
				return nums[mid];
			}
			if (nums[mid] > nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
 		}
		return Integer.MAX_VALUE;
	}
	
	
	public static int findMin3(int[] nums) {
		// If the list has just one element then return that element.
		if (nums.length == 1) {
			return nums[0];
		}

		// initializing left and right pointers.
		int left = 0, right = nums.length - 1;

		// if the last element is greater than the first element then there is no
		// rotation.
		// e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
		// Hence the smallest element is first element. A[0]
		if (nums[right] > nums[0]) {
			return nums[0];
		}

		// Binary search way
		while (right >= left) {
			// Find the mid element
			int mid = left + (right - left) / 2;

			// if the mid element is greater than its next element then mid+1 element is the
			// smallest
			// This point would be the point of change. From higher to lower value.
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}

			// if the mid element is lesser than its previous element then mid element is
			// the smallest
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}

			// if the mid elements value is greater than the 0th element this means
			// the least value is still somewhere to the right as we are still dealing with
			// elements
			// greater than nums[0]
			if (nums[mid] > nums[0]) {
				left = mid + 1;
			} else {
				// if nums[0] is greater than the mid value then this means the smallest value
				// is somewhere to
				// the left
				right = mid - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
		System.out.println(findMin3(new int[] {3, 4, 5, 6, 2}));
		System.out.println(findMin3(new int[] {2,3,4,5,1}));
	}
}
