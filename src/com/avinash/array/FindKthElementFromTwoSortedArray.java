package com.avinash.array;

public class FindKthElementFromTwoSortedArray {

	/**
	 * @param arrayA
	 * @param arrayB
	 * @param aStart
	 * @param aEnd
	 * @param bStart
	 * @param bEnd
	 * @param k
	 * @return
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
			// 
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
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 11, 13 };
		int[] b = { 3, 4, 6, 8, 12 };
		
//		System.out.println(findMedianSortedArray(a, b));
//		System.out.println(findKthElement(b, a, 0, b.length, 0, a.length,4));
		System.out.println(findKthElement(a, b, 0, a.length, 0, b.length,4));
		
	}
}