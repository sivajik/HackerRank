package com.hr.problemsolving.easy;

public class RunningTimeShifts {

	public static void main(String[] args) {
		System.out.println(runningTime(new int[] {2, 1, 3, 1, 2}));
	}

	static int runningTime(int[] A) {
		int shifts = 0;
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				j = j - 1;
				shifts++;
			}
			A[j + 1] = value;
		}
		// System.out.println(Arrays.toString(A));
		return shifts;

	}

}
