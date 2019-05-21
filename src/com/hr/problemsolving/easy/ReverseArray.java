package com.hr.problemsolving.easy;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 4, 3, 2, 5 })));
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(reverseArray(new int[] { 1, 2})));
		System.out.println(Arrays.toString(reverseArray(new int[] { 1})));

	}

	static int[] reverseArray(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			int j = a.length - i - 1;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		return a;
	}
}
