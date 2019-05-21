package com.hr.problemsolving.easy;

import java.util.Arrays;

public class MarksCakeWalk {

	public static void main(String[] args) {
		System.out.println(marcsCakewalk(new int[] { 1, 3, 2 }));
		System.out.println(marcsCakewalk(new int[] { 7, 4, 9, 6 }));

	}

	// Complete the marcsCakewalk function below.
	static long marcsCakewalk(int[] calorie) {
		Arrays.sort(calorie);
		long answer = 0l;
		for (int i = calorie.length - 1; i >= 0; i--) {
			answer += (calorie[calorie.length - i - 1] * Math.pow(2, i));
		}

		return answer;
	}
}
// 4 6 7 9