package com.hr.problemsolving.hard;

import java.util.HashMap;

public class ArrayManipulation {

	public static void main(String[] args) {
		System.out.println(arrayManipulation(5, new int[][] { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } }));

		System.out.println(arrayManipulation(10, new int[][] { { 2, 6, 8 }, { 3, 5, 7 }, { 1, 8, 1 }, { 5, 9, 15 } }));
	}

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long max = Long.MIN_VALUE;

		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		long tempRes = 0;
		for (int i = 0; i < queries.length; i++) {
			int startIndex = queries[i][0];
			int endIndex = queries[i][1];
			int quantity = queries[i][2];

			for (int j = startIndex; j <= endIndex; j++) {
				if (map.containsKey(j)) {
					tempRes = (long) (quantity + map.get(j));
				} else {
					tempRes = (long) quantity;
				}
				map.put(j, tempRes);
				if (tempRes > max) {
					max = tempRes;
				}
			}
		}
		return max;
	}
}
