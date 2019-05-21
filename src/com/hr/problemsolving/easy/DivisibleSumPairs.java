package com.hr.problemsolving.easy;

public class DivisibleSumPairs {
	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 6, 1, 2 };
		System.out.println(divisibleSumPairs(a.length, 3, a));
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (i < j && (ar[i] + ar[j]) % k == 0) {
					System.out.println(i + " " + j + " => " + ar[i] + " + " + ar[j]);
					count++;
				}
			}
		}
		return count;
	}
}
