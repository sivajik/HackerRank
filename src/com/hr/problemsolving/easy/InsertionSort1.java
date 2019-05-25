package com.hr.problemsolving.easy;

public class InsertionSort1 {

	public static void main(String[] args) {
		insertionSort1(new int[] { 1, 2, 4, 5, 3 });
	}

	public static void insertionSort1(int[] A) {
		int value = A[A.length - 1];
		int j = A.length - 2;
		while (j >= 0 && A[j] > value) {
			A[j + 1] = A[j];
			j = j - 1;
			printArray(A);
		}
		A[j + 1] = value;

		printArray(A);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

}
