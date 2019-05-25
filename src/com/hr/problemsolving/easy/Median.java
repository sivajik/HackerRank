package com.hr.problemsolving.easy;

import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int findMedian(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length / 2];
	}
}
