package com.hr.problemsolving.easy;

public class InsertionSort2 {

	public static void main(String[] args) {
		insertionSort2(6, new int[] {1, 4, 3, 5, 6, 2});
	}

	public static void insertionSort2(int n, int[] A) {
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = value;
			printArray(A);
		}
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

}
