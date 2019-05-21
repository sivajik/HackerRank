package com.hr.problemsolving.easy;

import java.util.Arrays;

public class Pairs {

	public static void main(String[] args) {
		System.out.println(pairs(2, new int[] {1 ,5 ,3, 4, 2}));
	}

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int pairAt = binSearch(arr, 0, arr.length - 1, Math.abs(k - arr[i])); 
			if (i != pairAt && pairAt != -1) {
				System.out.println("Pair Exists: " + i + " " + pairAt);
				count ++;
			}
		}
		return count;
	}

	static int binSearch(int[] a, int p, int r, int lookFor) {
		if (p <= r) {
			int mid = p + (r - p) / 2;
			if (a[mid] == lookFor) {
				return mid;
			} else if (lookFor < a[mid]) {
				return binSearch(a, p, mid - 1, lookFor);
			} else if (lookFor > a[mid]) {
				return binSearch(a, mid + 1, r, lookFor);
			}
		}
		return -1;
	}
}
