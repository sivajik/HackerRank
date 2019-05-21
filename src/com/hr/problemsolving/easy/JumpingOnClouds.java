package com.hr.problemsolving.easy;

public class JumpingOnClouds {

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 1, 0 }, 2));
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0 }, 2));
		System.out.println(jumpingOnClouds(new int[] { 1, 1, 1, 0, 1, 1, 0, 0, 0, 0 }, 3));
	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c, int k) {
		int currentIndex = 0, energy = 100;
		do {
			currentIndex = (currentIndex + k) % c.length;
			energy = c[currentIndex] == 0 ? energy - 1 : energy - 1 - 2;
		} while (currentIndex != 0);

		return energy;
	}
}
