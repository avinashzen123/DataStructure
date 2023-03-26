package com.avinash.array;

public class FindKthElementFromTwoSortedArray {

	/**
	 * https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/
	 * 
	 * aMid = aStart + (aStart+aEnd)/2  add it with aStart because aStart may or may not be zero
	 * 
	 * after we selected aMid then we can need to select bMid in proprtionate way. it should not 
	 * 		be bStart + (bStart + bMid)/2 because it should be realtive to K
	 * 
	 * after aMid we are left with k - aMid - 1 element so bMid = bStart + left element after aMid
	 * 
	 * bMid = bStart - (k-aMid-1) 
	 * 
	 * if a[aMid] > b[bMid]
	 * 		we need to start after bMid 
	 * 
	 * else 
	 * 		we need to start after aMid
	 * 
	 */
	public static int findKthElement(int[] arrayA, int[] arrayB, int aStart, int aEnd, int bStart, int bEnd, int k) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		if (aLen == 0) return arrayB[bStart + k];
		if (bLen == 0) return arrayA[aStart + k];
		if (k == 0) return arrayA[aStart] < arrayB[bStart] ? arrayA[aStart] : arrayB[bStart];
		
		int aMid = aStart  + (aStart + aEnd)/2;
		int bMid = bStart + ( k - aMid - 1 < 0 ? 0 : k - aMid - 1); 

		System.out.println("K : " + k + " aStart " + aStart + " aEnd : " + aEnd + " aMid : " + aMid + " bstart : "
				+ bStart + " BEnd :" + bEnd + " bMid : " + bMid);
		
		if (arrayA[aMid] > arrayB[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKthElement(arrayA, arrayB, aStart, aEnd, bStart, bEnd, k);
	}
	
	
	public static int kthSmallestProduct(int[] num1, int[] num2, int k, int num1Start, int num1End, int num2Start, int num2End) {
        int num1Len = num1End - num1Start + 1;
        int num2Len = num2End - num2Start + 1;
        if (num1Len == 0) return num2[num2Start + k];
        if (num2Len == 0) return num1[num1Start + k];
        if (k == 0) 
            return num1[num1Start] < num2[num2Start] ? num1[num1Start] : num2[num2Start];
        int num1Mid = num1Start + (num1Start + num1End) / 2;
        int num2Mid = num2Start + ((k - num1Mid - 1) < 0 ? 0 : (k - num1Mid - 1));
        if (num1[num1Mid] < num2[num2Mid]) {
            k = k - (num1Mid - num1Start + 1);
            num1Start = num1Mid + 1;
            num2End = num2Mid;
        } else {
            k = k - (num2Mid - num2Start + 1);
            num2Start = num2Mid + 1;
            num1End = num1Mid;
        }
        return kthSmallestProduct(num1, num2, k, num1Start, num1End, num2Start, num2End);
    }
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 11, 13 };
		int[] b = { 3, 4, 6, 8, 12 };
		
//		System.out.println(findMedianSortedArray(a, b));
//		System.out.println(findKthElement(b, a, 0, b.length, 0, a.length,4));
		System.out.println(findKthElement(a, b, 0, a.length, 0, b.length,4));
		
		System.out.println(kthSmallestProduct(a, b, 4, 0, a.length, 0, b.length));
		
		int[] num1 = {2, 5};
		int[] num2 = {3, 4};
		System.out.println(kthSmallestProduct(num1, num2, 2, 0, num1.length, 0, num2.length));
	}
}