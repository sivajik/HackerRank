package com.hr.problemsolving.easy;

public class BeautifulTriplets {

	public static void main(String[] args) {
		System.out.println(beautifulTriplets(3, new int[] {1, 2, 4, 5, 7, 8, 10}));
		System.out.println();
		

	}

	// Complete the beautifulTriplets function below.
	static int beautifulTriplets(int d, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length - 1; j++) {
				int diff = arr[j] - arr[i];
				if (diff == d) {
					int thirdElemAt = binarySearch(arr, j + 1, arr.length - 1, arr[j] + diff);
					if (thirdElemAt != -1) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[thirdElemAt]);
						count++;
					}
				}
			}
		}
		return count;
	}

	static int binarySearch(int[] arr, int p, int r, int lookFor) {
		if (p <= r) {
			int mid = p + (r - p) / 2;
			if (arr[mid] == lookFor) {
				return mid;
			} else if (lookFor < arr[mid]) {
				return binarySearch(arr, p, mid - 1, lookFor);
			} else if (lookFor > arr[mid]) {
				return binarySearch(arr, mid + 1, r, lookFor);
			}
		}
		return -1;
	}
}
