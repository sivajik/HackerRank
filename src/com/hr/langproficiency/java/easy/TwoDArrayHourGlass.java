package com.hr.langproficiency.java.easy;

public class TwoDArrayHourGlass {
	public static void main(String[] args) throws Exception {
		int[][] a = new int[][] {
			{1, 1, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 0, 2, 4, 4, 0},
			{0, 0, 0, 2, 0, 0},
			{0, 0, 1, 2, 4, 0}
		};
		System.out.println(arrayWithMaxSum(a));
	}

	public static int sumOfHourGlass(int[][] a, int i, int j) {
		int fRowSum = a[i][j] + a[i][j + 1] + a[i][j + 2];
		int lRowSum = a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];
		int result = fRowSum + lRowSum + a[i + 1][j + 1];
		return result;
	}

	public static int arrayWithMaxSum(int[][] a) {
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				int maxSumCalc = sumOfHourGlass(a, i, j);
				if (maxSumCalc > maxSum) {
					maxSum = maxSumCalc;
				}
			}
		}
		
		return maxSum;
	}
}
