package com.hr.problemsolving.easy;

public class SaveThePrisoner {

	public static void main(String[] args) {
		System.out.println(saveThePrisoner(5, 2, 1));
		System.out.println(saveThePrisoner(5, 2, 2));

		System.out.println(saveThePrisoner(7, 19, 2));
		System.out.println(saveThePrisoner(4, 6, 2));
	}

	// Complete the saveThePrisoner function below.
	static int saveThePrisoner(int n, int m, int s) {
		int a = s + m - 1;
		if (a > n) {
			if (a % n == 0) {
				return n;
			}
			return a % n;
		}

		return a;
	}

}
