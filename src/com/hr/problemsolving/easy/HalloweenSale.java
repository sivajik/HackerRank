package com.hr.problemsolving.easy;

public class HalloweenSale {

	public static void main(String[] args) {
		System.out.println(howManyGames(20, 3, 6, 80));
		System.out.println(howManyGames(63, 64, 9, 1242));
		System.out.println(howManyGames(100, 19, 1, 180));
	}

	// Complete the howManyGames function below.
	static int howManyGames(int p, int d, int m, int s) {
		int remainingAmount = s - p;
		if (remainingAmount < 0) {
			return 0;
		} else {
			int total = 1;
			int eachGameCost = p - d;
			if (remainingAmount - eachGameCost >= 0) {
				while (eachGameCost >= m) {
					total = total + 1;
					remainingAmount = remainingAmount - eachGameCost;
					eachGameCost -= d;
				}
				eachGameCost = m;
				while (remainingAmount - eachGameCost >= 0) {
					remainingAmount = remainingAmount - eachGameCost;
					total++;
				}
			}
			return total;
		}
	}

}
