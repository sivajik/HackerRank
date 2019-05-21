package com.hr.problemsolving.easy;

public class DiagnalDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int diagonalDifference(int[][] arr) {
		int primDiag = 0;
		for (int i = 0; i < arr.length; i++) {
			primDiag += arr[i][i];
		}

		int secDiag = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			secDiag += arr[i][arr.length - i - 1];
		}

		return Math.abs(primDiag - secDiag);
	}
}
