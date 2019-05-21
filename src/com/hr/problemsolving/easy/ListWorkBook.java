package com.hr.problemsolving.easy;

public class ListWorkBook {

	public static void main(String[] args) {
		System.out.println(workbook(10, 5, new int[] { 3, 8, 15, 11, 14, 1, 9, 2, 24, 31}));
		System.out.println("===");
		System.out.println(workbook(5, 3, new int[] { 4, 2, 6, 1, 10}));
	}

	
	
	// Complete the workbook function below.
	static int workbook(int n, int k, int[] arr) {
		int totalBucketsNeeded = 0;

		for (int i = 0; i < arr.length; i++) {
			int elem = arr[i];
			int newElem = elem <= k ? k : (elem % k == 0 ? elem : elem + (k - elem % k));
			totalBucketsNeeded += (newElem / k);
		}

		System.out.println("Total Buckets Needed: " + totalBucketsNeeded);
		
		int[][] spots = new int[totalBucketsNeeded][];
		for (int i = 0; i < spots.length; i++) {
			spots[i] = new int[k];
		}

		int row = 0;
		int col = 0;
		for (int i = 0; i < arr.length; i++) {
			int elem = arr[i];
			int newElem = elem <= k ? k : (elem % k == 0 ? elem : elem + (k - elem % k));
			System.out.println("elem & new elem " + elem + " " + newElem);

			int c = 0;
			for (int j = 0; j < newElem; j++) {
				if (j < elem) {
					spots[row][col] = c++;
				} else {
					spots[row][col] = -999;
				}
				col = (col + 1);
				if (col == k) {
					row = row + 1;
					col = 0;
				}
			}
		}

		return print(spots);
	}

	static int print(int[][] spots) {
		int matchingCount = 0;
		for (int i = 0; i < spots.length; i++) {
			for (int j = 0; j < spots[i].length; j++) {
				if (i == spots[i][j]) {
					matchingCount++;
				}
				System.out.print(spots[i][j] + "" + (i == spots[i][j] ? '*' : ' ') + " ");
			}
			System.out.println();
		}
		return matchingCount;
	}
}
