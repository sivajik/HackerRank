package com.hr.problemsolving.easy;

public class PascalTriange {
	public static void main(String[] args) throws Exception {
		int rowNumber = 20;
		printPascal(rowNumber);
		System.out.println("====");
		printPascalForRow(rowNumber);
	}

	public static void printPascal(int row) {
		for (int currRow = 1; currRow <= row; currRow++) {
			for (int currCol = 1; currCol <= currRow; currCol++) {
				System.out.print(pascal(currRow, currCol) + "\t");
			}
			System.out.println();
		}
	}

	public static void printPascalForRow(int currRow) {
		for (int currCol = 1; currCol <= currRow; currCol++) {
			System.out.print(pascal(currRow, currCol) + "\t");
		}
		System.out.println();

	}

	public static int pascal(int row, int col) {
		if (col == 1) {
			return 1;
		} else if (row == col) {
			return 1;
		} else {
			return pascal(row - 1, col - 1) + pascal(row - 1, col);
		}
	}
}