package com.hr.problemsolving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MigratoryBirds {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(4);
		l.add(3);
		l.add(2);
		l.add(1);
		l.add(3);
		l.add(4);
		System.out.println(migratoryBirds(l));

	}

	static int migratoryBirds(List<Integer> arr) {
		Pair[] array = new Pair[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Pair(i + 1, 0);
		}

		for (Integer i : arr) {
			array[i - 1].totalCount = array[i - 1].totalCount + 1;
		}

		Arrays.sort(array, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.totalCount - o2.totalCount;
			}
		});

		System.out.println(Arrays.toString(array));
		
		int maxCount = array[array.length - 1].totalCount;
		int maxCountIndex = array[array.length - 1].index;

		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i].totalCount == maxCount) {
				if (array[i].index < maxCountIndex) {
					maxCountIndex = array[i].index;
				}
			} else {
				break;
			}
		}

		System.out.println("Final answer: " + maxCountIndex);
		return maxCountIndex;
	}
	
	static class Pair {
		int index;
		int totalCount;

		public Pair(int index, int totalCount) {
			super();
			this.index = index;
			this.totalCount = totalCount;
		}

		@Override
		public String toString() {
			return "[" + index + " -> " + totalCount + "]";
		}

	}
}

