package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();

		l.add(2);
		l.add(5);
		l.add(1);
		l.add(3);
		l.add(4);
		l.add(4);
		l.add(3);
		l.add(5);
		l.add(1);
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(4);
		l.add(1);
		l.add(3);
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(1);

		System.out.println(birthday(l, 18, 7));
	}

	static int birthday(List<Integer> s, int d, int m) {
		int ways = 0;
		if (s.size() == 1 && m == 1 && s.get(0) == d) {
			return 1;
		}

		for (int i = 0; i < s.size() ; i++) {
			int sum = 0;
			int j = i;
			for (int counter = 0; counter < m && j < s.size(); counter++) {
				sum += s.get(j++);
			}

			if (sum == d) {
				ways++;
			}
		}
		return ways;
	}
}
