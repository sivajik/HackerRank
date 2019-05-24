package com.hr.langproficiency.java.easy;

import java.util.Arrays;

public class ServiceLane {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(serviceLane(8, new int[][] {
				{0, 3},
				{4, 6},
				{6, 7},
				{3, 5},
				{0, 7}
		}, new int[] {2, 3, 1, 2, 3, 2, 3, 3})));
		
		System.out.println(Arrays.toString(serviceLane(5, new int[][] {
			{2, 3},
			{1, 4},
			{2, 4},
			{2, 4},
			{2, 3}
	}, new int[] {1, 2, 2, 2, 1})));

	}

	// Complete the serviceLane function below.
	static int[] serviceLane(int n, int[][] cases, int[] width) {
		int[] results = new int[cases.length];
		int testCasesCount = cases.length;
		for (int i = 0; i < testCasesCount; i++) {
			int startIndex = cases[i][0];
			int endIndex = cases[i][1];

			int minEle = Integer.MAX_VALUE;
			for (int j = startIndex; j <= endIndex; j++) {
				if (width[j] < minEle) {
					minEle = width[j];
				}
			}
			results[i] = minEle;
		}
		return results;
	}

}
