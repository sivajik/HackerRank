package com.hr.problemsolving.easy;

public class CountingValleys {

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));

	}

	static int countingValleys(int n, String s) {
		int valleyRunningSum = 0;
		int mountainRunningSum = 0;
		int totalValleysVisited = 0;
		for (char c : s.toCharArray()) {
			if (c == 'D') {
				valleyRunningSum = valleyRunningSum - 1;
			} else if (c == 'U') {
				mountainRunningSum = mountainRunningSum + 1;
			}

			if (c == 'U' && (valleyRunningSum + mountainRunningSum) == 0 && valleyRunningSum < 0 && mountainRunningSum > 0) {
				totalValleysVisited++;
			}
		}
		return totalValleysVisited;

	}
}
