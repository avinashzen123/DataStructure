package com.avinash.array;

public class MedianOfTwoSortedArray {

	public static double findMedianSortedArray(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if ((m + n) % 2 != 0) {
			return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
		} else {
			return (findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1))
					* 0.5;
		}
	}

	/**
	 * 
	 * 
	 * @param a
	 * @param b
	 * @param k
	 * @param aStart
	 * @param aEnd
	 * @param bStart
	 * @param bEnd
	 * @return
	 */
	private static double findKth(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		if (aLen == 0)
			return b[bStart + k];
		if (bLen == 0)
			return a[aStart + k];
		if (k == 0)
			return a[aStart] < b[bStart] ? a[aStart] : b[bStart];

//		int aMid = aLen * k / (aLen + bLen);
		int aMid = (aStart + aEnd)/2;
		int bMid = k - aMid - 1 < 0 ? 0: k - aMid - 1;

		aMid = aMid + aStart;
		bMid = bMid + bStart;
		System.out.println("K : " + k + " aStart " + aStart + " aEnd : " + aEnd + " aMid : " + aMid + " bstart : "
				+ bStart + " BEnd :" + bEnd + " bMid : " + bMid);
		if (a[aMid] > b[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
	}

	/**
	 * https://youtu.be/q6IEA26hvXc
	 * =
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 11, 13 };
		int[] b = { 3, 4, 6, 8, 12 };
		
//		System.out.println(findMedianSortedArray(a, b));
		System.out.println(findKth(b, a, 4, 0, b.length, 0, a.length));
		System.out.println(findKth(a, b, 4, 0, a.length, 0, b.length));
	}

}
