package com.hr.problemsolving.easy;

public class MarsExploration {

	public static void main(String[] args) {
		System.out.println(marsExploration("SOSSPSSQSSOR"));
		System.out.println(marsExploration("SOSSOT"));
		System.out.println(marsExploration("SOSSOSSOS"));
		System.out.println(marsExploration("SOSOOSOSOSOSOSSOSOSOSOSOSOS"));
	}

	// Complete the marsExploration function below.
	static int marsExploration(String s) {
		int missCount = 0;
		for (int i = 0; i < s.length(); i = i + 3) {
			if (s.charAt(i) != 'S') {
				missCount++;
			}
			if (s.charAt(i+1) != 'O') {
				missCount++;				
			}
			if (s.charAt(i+2) != 'S') {
				missCount++;				
			}			
		}
		return missCount;
	}
}
