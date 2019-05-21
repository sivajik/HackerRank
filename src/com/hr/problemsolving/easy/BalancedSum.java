package com.hr.problemsolving.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BalancedSum {

	public static void main(String[] args) {
		//int[] arr = { 5, 6, 8, 11 };
		int[] arr = { 1, 2, 3, 3};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(balancedSums(list));

	}

	// Complete the balancedSums function below.
	static String balancedSums(List<Integer> arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int runningSum = 0;
		for (int index = 0; index < arr.size(); index++) {
			int elem = arr.get(index);
			runningSum += elem;
			map.put(index, runningSum);
		}

		System.out.println("Total sum: " + runningSum);
		System.out.println(map);

		String result = "NO";
		for (int i = 0; i < arr.size(); i++) {
			int elem = arr.get(i);
			int tempSum = runningSum - elem;
			int sumUntilIndex = map.get(i - 1) == null ? 0 : map.get(i - 1);
			if (sumUntilIndex == tempSum / 2) {
				result = "YES";
				System.out.println("Index: " + i + " Sum: " + sumUntilIndex);
				break;
			}
		}
		return result;
	}
}
