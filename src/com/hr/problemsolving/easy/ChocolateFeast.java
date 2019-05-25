package com.hr.problemsolving.easy;

public class ChocolateFeast {

	public static void main(String[] args) {
		System.out.println(chocolateFeast(15, 3, 2)); // 9
		System.out.println(chocolateFeast(10, 2, 5)); // 6
		System.out.println(chocolateFeast(12, 4, 4)); // 3
		System.out.println(chocolateFeast(6, 2, 2)); //5
	}

	// Complete the chocolateFeast function below.
	static int chocolateFeast(int n, int c, int m) {
		int numOfBarsEaten = n / c;
		int wrapperCount = numOfBarsEaten;

		while (wrapperCount > 0 && wrapperCount >= m) {
			int newBarsBought = wrapperCount / m;
			numOfBarsEaten = numOfBarsEaten + newBarsBought;
			if (newBarsBought > 0) {
				wrapperCount = newBarsBought + (wrapperCount % m);

				if (wrapperCount == m) {
					numOfBarsEaten++;
					break;
				}
			}
		}
		return numOfBarsEaten;

	}
}