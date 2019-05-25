package com.hr.problemsolving.easy;

public class StrangeCounter {

	public static void main(String[] args) {
		System.out.println(strangeCounter(1000000000000l)); // 649267441662
	}

	// Complete the strangeCounter function below.
	static long strangeCounter(long t) {
		long sIndex = 1;
		long eIndex = 3;
		long n = 1;
		long window = eIndex - sIndex + 1;
		long cycle = 1;

		while (!(t >= sIndex && t <= eIndex)) {
			sIndex = sIndex + window;
			n = (long) (3l * Math.pow(2.0, cycle));
			eIndex = sIndex + (n - 1);
			window = (eIndex - sIndex + 1);
			cycle++;
		}
		return (long) (getCycleSumValue(cycle, sIndex) - t);
	}

	static long getCycleSumValue(long cycle, long sIndex) {
		return (long) (sIndex + 3.0 * Math.pow(2.0, cycle - 1));
	}
}
