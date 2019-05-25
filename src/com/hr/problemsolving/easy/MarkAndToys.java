package com.hr.problemsolving.easy;

import java.util.Arrays;

public class MarkAndToys {

	public static void main(String[] args) {
		// System.out.println(maximumToys(new int[] { 1, 2, 3, 4 }, 7));
		System.out.println(maximumToys(new int[] { 1, 12, 5, 111, 200, 1000, 10 }, 50));
	}

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);

		return atMostSum(prices, k);
	}

	public static int atMostSum(int arr[], int k) {
		int i = 0;
		while (k - arr[i] >= 0) {
			k = k - arr[i];
			i++;
		}
		return i;
	}
}