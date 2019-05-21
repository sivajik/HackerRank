package com.hr.problemsolving.easy;

public class BetweenTwoSets {

	public static void main(String[] args) {
		int[] a = {2, 4};
		int[] b = {16, 32, 96};
		System.out.println(getTotalX(a, b));
	}

	static int getTotalX(int[] a, int[] b) {
		int count = 0;

		for (int i = 2; i <= 100; i++) {
			boolean areAllFactors = true;
			for (int elem : a) {
				if (i % elem != 0) {
					areAllFactors = false;
					break;
				}
			}

			if (areAllFactors) {
				boolean factorOfall = true;
				for (int elem : b) {
					if (elem % i != 0) {
						factorOfall = false;
						break;
					}
				}
				if (factorOfall) {
					System.out.println("Found a successful number: " + i);
					count++;
				}
			} else {
				continue;
			}
		}
		return count;
	}
}
