package com.hr.problemsolving.easy;

public class TwodArrayHourGlass {

	public static void main(String[] args) {
		System.out.println(hourglassSum(new int[][] { { -9, -9, -9, 1, 1, 1 }, { 0, -9, 0, 4, 3, 2 },
				{ -9, -9, -9, 1, 2, 3 }, { 0, 0, 8, 6, 6, 0 }, { 0, 0, 0, -2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } }));
	}

	static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = hourGlassSumVal(arr, i, j);
				System.out.println("Sum: " + sum);
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	static int hourGlassSumVal(int[][] arr, int i, int j) {
		int sum = 0;
		for (int row = 0; row <= 2; row++) {
			for (int col = 0; col <= 2; col++) {
				sum += arr[i + row][j + col];
			}
		}
		sum = sum - arr[i + 1][j] - arr[i + 1][j + 2];
		return sum;
	}
}
