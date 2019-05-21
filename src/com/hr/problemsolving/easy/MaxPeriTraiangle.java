package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxPeriTraiangle {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maximumPerimeterTriangle(new int[] { 1, 2, 3, 4, 5, 10 })));
		System.out.println(Arrays.toString(maximumPerimeterTriangle(new int[] { 1, 1, 1, 3, 3 })));
		System.out.println(Arrays.toString(maximumPerimeterTriangle(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(maximumPerimeterTriangle(new int[] { 1 , 1,  1,  2,  3,  5})));

	}

	// Complete the maximumPerimeterTriangle function below.
	static int[] maximumPerimeterTriangle(int[] sticks) {
		Arrays.sort(sticks);

		List<Pair> list = new ArrayList<Pair>();

		int currPerimeter = Integer.MIN_VALUE;
		for (int i = 2; i < sticks.length; i++) {
			// valid triangle a + b > c
			if (sticks[i - 2] + sticks[i - 1] > sticks[i]) {
				if (sticks[i - 2] + sticks[i - 1] + sticks[i] > currPerimeter) {
					currPerimeter = sticks[i - 2] + sticks[i - 1] + sticks[i];
				}
			}
		}

		// System.out.println(currPerimeter);
		
		for (int i = 2; i < sticks.length; i++) {
			if (currPerimeter == sticks[i - 2] + sticks[i - 1] + sticks[i]) {
				list.add(new Pair(sticks[i - 2], sticks[i - 1], sticks[i]));
			}
		}

		if (list.isEmpty()) {
			return new int[] { -1 };
		} else {
			list.sort(new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if (o1.k - o2.k == 0) {
						if (o1.j - o2.j == 0) {
							return o1.i - o2.i;
						} else {
							return o1.j - o2.j;
						}
					} else {
						return o1.k - o2.k;
					}
				}
			});

			return new int[] { list.get(list.size() - 1).i, list.get(list.size() - 1).j, list.get(list.size() - 1).k };
		}
	}

	static class Pair {
		int i;
		int j;
		int k;

		Pair(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}
}
