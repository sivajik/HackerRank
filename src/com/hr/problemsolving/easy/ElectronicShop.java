package com.hr.problemsolving.easy;

import java.util.Arrays;

public class ElectronicShop {

	public static void main(String[] args) {
		System.out.println(getMoneySpent(new int[] { 40, 50, 60 }, new int[] { 5, 8, 12 }, 60));
		System.out.println(getMoneySpent(new int[] { 3, 1 }, new int[] { 5, 2, 8 }, 10));
		System.out.println(getMoneySpent(new int[] { 4 }, new int[] { 5 }, 5));
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int kbStart = keyboards.length - 1;
		int drStart = drives.length - 1;

		int max = Integer.MIN_VALUE;
		for (int i = kbStart; i >= 0; i--) {
			for (int j = drStart; j >= 0; j--) {
				int currTotal = keyboards[i] + drives[j];
				if (currTotal > b) {
					continue;
				} else if (currTotal <= b) {
					if (currTotal > max) {
						max = currTotal;
					}
				}
			}
		}
		return max == Integer.MIN_VALUE ? -1 : max;
	}
}
