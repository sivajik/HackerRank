package com.hr.problemsolving.easy;

public class JumpingOnTheClouds {

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] {0, 0, 1, 0 , 0, 1, 0}));

	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int count = 0;
		final int THUNDERHEAD = 1;

		for (int i = 0; i < c.length;) {
			if (i < c.length) {
				if (i + 2 < c.length && c[i + 2] != THUNDERHEAD) {
					System.out.println("Jump from: " + i + " -> " + (i + 2));
					i = i + 2;
					count++;
				} else if (i + 1 < c.length && c[i + 1] != THUNDERHEAD) {
					System.out.println("Jump from: " + i + " -> " + (i + 1));
					i = i + 1;
					count++;
				} else {
					break;
				}
			} else {
				break;
			}

		}
		return count;
	}
}
