package com.hr.problemsolving.easy;

public class BreakingRecords {

	public static void main(String[] args) {
		int[] a = { 10, 5, 20, 20, 4, 5, 2, 25, 1 };
		int[] r = breakingRecords(a);
		print(r);
		
		int[] b = {3 ,4, 21, 36, 10, 28, 35, 5, 24, 42};
		int[] s = breakingRecords(b);
		print(s);
	}

	static int[] breakingRecords(int[] scores) {
		int highestScore = scores[0];
		int lowestScore = scores[0];

		int highestScoreBeaten = 0;
		int lowestScoreBeaten = 0;

		for (int score : scores) {
			if (score > highestScore) {
				highestScore = score;
				highestScoreBeaten++;
			}

			if (score < lowestScore) {
				lowestScore = score;
				lowestScoreBeaten++;
			}
		}
		return new int[] { highestScoreBeaten, lowestScoreBeaten };
	}

	static void print(int[] a) {
		for (int elem : a) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
