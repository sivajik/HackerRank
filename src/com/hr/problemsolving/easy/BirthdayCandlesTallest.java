package com.hr.problemsolving.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayCandlesTallest {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 3 };
		int x = birthdayCakeCandles(a);
		System.out.println(x);

	}

	static int birthdayCakeCandles(int[] ar) {
		List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		});

		int maxElem = list.get(0);
		return (int) list.stream().filter(i -> (i == maxElem)).count();
	}

}
