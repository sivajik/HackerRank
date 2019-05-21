package com.hr.problemsolving.easy;

public class UtopianTree {

	public static void main(String[] args) {
		System.out.println(utopianTree(5));
	}

	// Complete the utopianTree function below.
	static int utopianTree(int n) {
		int initialHeight = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				initialHeight = 2 * initialHeight;
			} else {
				initialHeight = 1 + initialHeight;
			}
		}
		return initialHeight;
	}
}
