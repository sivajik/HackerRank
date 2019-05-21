package com.hr.problemsolving.easy;

import java.util.Arrays;

public class GradingStudents {

	public static void main(String[] args) {
		int[] g = { 73, 67, 38, 33 };
		g = gradingStudents(g);
		System.out.println(Arrays.toString(g));
	}

	static int[] gradingStudents(int[] grades) {
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];
			if (grade < 38) {
				;
			} else {
				int diff = 5 - (grade % 5);
				if (diff < 3) {
					grades[i] = diff + grade;
				}
			}
		}
		return grades;
	}
}
