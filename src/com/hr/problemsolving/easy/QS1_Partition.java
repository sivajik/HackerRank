package com.hr.problemsolving.easy;

public class QS1_Partition {

	public static void main(String[] args) {
		int[] a = { 7, 2, 6, 0, 3, 1, 4, 8, 9, 5 };
		print(a);
		partition(a, 0, a.length - 1);
		print(a);
	}

	public static void print(int[] a) {
		for (int elem : a) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void partition(int[] a, int p, int r) {
		int randomPart = 0;
		swap (a, r, 0);
		
		int x = a[r]; // pivot
		int i = p - 1;

		for (int j = p; j <= r - 1; j++) {
			if (a[j] < x) {
				i = i + 1;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, r);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
