package com.hr.problemsolving.easy;

public class ApplesAndOranges {

	public static void main(String[] args) {
		countApplesAndOranges(7, 10, 4, 12, new int[] { 2, 3, -4 }, new int[] { 3, -2, -4 });
		countApplesAndOranges(7, 11, 5, 15, new int[] { -2, 2, 1 }, new int[] { 5, -6 });
	}

	// Complete the countApplesAndOranges function below.
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int appleCount = 0;
		for (int eachApple : apples) {
			if (isBetween(s, t, eachApple + a)) {
				appleCount++;
			}
		}

		int orangeCount = 0;
		for (int eachOrange : oranges) {
			if (isBetween(s, t, eachOrange + b)) {
				orangeCount++;
			}
		}
		System.out.println(appleCount);
		System.out.println(orangeCount);
	}

	static boolean isBetween(int s, int t, int value) {
		return value >= s && value <= t;
	}
}
