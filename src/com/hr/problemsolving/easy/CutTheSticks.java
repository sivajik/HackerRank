package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class CutTheSticks {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(cutTheSticks(new int[] { 5, 4, 4, 2, 2, 8 })));
		System.out.println(Arrays.toString(cutTheSticks(new int[] { 1, 2, 3, 4, 3, 3, 2, 1 })));
	}

	static int[] cutTheSticks(int[] arr) {

		Arrays.sort(arr);
		int startIndex = 0;
		int updatedCount = 0;
		int tempUpdatedcount = 0;
		int prevLen = arr.length;
		int minElem = 0;

		ArrayList<Integer> results = new ArrayList<Integer>();
		System.out.println("So Array Length after update is  " + prevLen);
		results.add(prevLen);

		while (true) {
			for (int i = startIndex; i < arr.length; i = i + updatedCount) {
				minElem = arr[i];
				// System.out.println("Min Elem: " + minElem);

				updatedCount = 0;
				for (int j = i; j < arr.length; j++) {
					if (arr[j] == minElem && minElem != 0) {
						arr[j] = arr[j] - minElem;
						updatedCount++;
					} else {
						arr[j] = arr[j] - minElem;
					}
				}
				if (updatedCount == 0) {
					return null;
				}
				tempUpdatedcount = updatedCount;
				prevLen = prevLen - tempUpdatedcount;
				// System.out.println("Updated in this iteratio: " + tempUpdatedcount);
				System.out.println("So Array Length after update is  " + prevLen);
				results.add(prevLen);
			}
			break;
		}
		int[] op = new int[results.size() - 1];
		for (int idx = 0; idx < results.size() - 1; idx++) {
			op[idx] = results.get(idx);
		}
		return op;
	}
}
