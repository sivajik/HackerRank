package com.hr.problemsolving.easy;

public class MinimumDistances {

	public static void main(String[] args) {
		System.out.println(minimumDistances(new int[] { 7, 1, 3, 4, 1, 7 }));
		System.out.println(minimumDistances(new int[] { 1, 2, 3, 4, 10 }));

	}

	static int minimumDistances(int[] a) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					if (Math.abs(i - j) < min) {
						min = Math.abs(i - j);
					}
				}
			}
		}
		if ( min == Integer.MAX_VALUE) {
			min = -1;
		}
		return min;
	}
}
