package com.hr.problemsolving.easy;

import java.util.Arrays;

public class ArrayLeftRotationGayleBook {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotLeft(new int[] {1, 2, 3, 4, 5}, 4)));

	}

	static int[] rotLeft(int[] a, int d) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[  (i + (a.length - d) ) % a.length] = a[i];
		}
		return result;
	}

}
