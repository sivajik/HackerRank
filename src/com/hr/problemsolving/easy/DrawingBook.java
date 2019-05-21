package com.hr.problemsolving.easy;

public class DrawingBook {

	public static void main(String[] args) {
		System.out.println(pageCount(6, 2));
		System.out.println(pageCount(5, 4));

	}

	static int pageCount(int n, int p) {
		int frontDistance = p / 2;
		int backDistance = (n / 2) - (p / 2);
		return Math.min(frontDistance, backDistance);
	}
}
