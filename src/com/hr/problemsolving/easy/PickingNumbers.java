package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingNumbers {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		/*
		 * a.add(1); a.add(1); a.add(2); a.add(2); a.add(4); a.add(5); a.add(5);
		 * a.add(5); a.add(5);
		 */

		/*
		 * a.add(4); a.add(6); a.add(5); a.add(3); a.add(3); a.add(1);
		 */

		/*
		 * a.add(1); a.add(2); a.add(2); a.add(3); a.add(1); a.add(2);
		 */

		int[] x = new int[] { 4, 97, 5, 97, 97, 4, 97, 4, 97, 97, 97, 97, 4, 4, 5, 5, 97, 5, 97, 99, 4, 97, 5, 97, 97,
				97, 5, 5, 97, 4, 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4, 97, 5, 4, 4, 97, 97, 97,
				5, 5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97, 97, 97, 5, 4, 4, 97, 4, 4, 97, 5, 97, 97, 97, 97, 4, 97, 5,
				97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5, 97, 97, 97 };
		for (int e : x) {
			a.add(e);
		}
		System.out.println(pickingNumbers(a));
	}

	public static int pickingNumbers(List<Integer> a) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int maxArraySize = Integer.MIN_VALUE;

		for (int elem : a) {
			if (counts.containsKey(elem)) {
				int modifiedCount = 1 + counts.get(elem);
				counts.put(elem, modifiedCount);
				// this is for arrays with SAME number which gives zero diff.
				if (modifiedCount > maxArraySize) {
					maxArraySize = modifiedCount;
				}
			} else {
				counts.put(elem, 1);
			}
		}

		System.out.println(counts);
		// Loop through all numbers and get the max array size;
		for (int elem : a) {
			if (counts.containsKey(elem + 1)) {
				int sum = counts.get(elem) + counts.get(elem + 1);
				if (sum > maxArraySize) {
					maxArraySize = sum;
				}
			}
		}

		for (int elem : a) {
			if (counts.containsKey(elem - 1)) {
				int sum = counts.get(elem) + counts.get(elem - 1);
				if (sum > maxArraySize) {
					maxArraySize = sum;
				}
			}
		}
		return maxArraySize;
	}
}
