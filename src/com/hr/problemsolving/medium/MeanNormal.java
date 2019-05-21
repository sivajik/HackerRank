package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeanNormal {
	/*
	 * public static void main(String[] args) { ArrayList<Integer> l = new
	 * ArrayList<Integer>(); l.add(1); l.add(3); l.add(4); l.add(11); l.add(10);
	 * 
	 * solve(new int[][] { { 1, 3, 4 }, { 11, 10 } }, new double[]
	 * {2.666666666666667, 10.5}, l); System.out.println("===="); }
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// Capture while reading itself..
		double[] means = new double[n];
		List<Long> l = new ArrayList<Long>();

       for (int a0 = 0; a0 < n; a0++) {
			int m_i = in.nextInt();
			
			long[] p_i = new long[m_i];
			long sum = 0l;
			for (int g = 0; g < m_i; g++) {
				p_i[g] = in.nextLong();
				sum += p_i[g];
				l.add(p_i[g]);
			}
			means[a0] = (double) (sum) / p_i.length;
		}
		solve(means, l);

		in.close();
	}

	static void solve(double[] means, List<Long> l) {
		double sum = 0.0d;

		boolean minFound = false;
		double min = Double.MAX_VALUE;
		for (double meanThisTime : means) {
			for (Long elem : l) {
				sum += Math.abs(meanThisTime - elem.longValue());
				if (minFound) {
					if (sum > min) {
						break;
					}
				}
			}
			if (sum < min) {
				min = sum;
				minFound = true;
			}
			sum = 0.0d;
		}
		System.out.printf("%.10f", min);
	}
}