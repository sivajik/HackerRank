package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;

public class ProfitTarger {

	public static void main(String[] args) {
		ArrayList<Integer> low = new ArrayList<Integer>();
		low.add(15);
		low.add(20);
		
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(20);
		x.add(15);
		
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		l.add(low);
		l.add(x);
		
		System.out.println(solve2(l));
	}

	static int solve2(List<List<Integer>> profits) {
		long pendingFromYesterday = 0;
		for (List<Integer> eachDay : profits) {
			long actual = (long) eachDay.get(0);
			long target = (long) eachDay.get(1) + pendingFromYesterday;
			
			if (target > actual) {
				pendingFromYesterday = target - actual;
			} else {
				pendingFromYesterday = 0;
			}
		}
		return pendingFromYesterday > 0 ? 1 : 0;
	}
	
	static class Pair {
		long a;
		long t;
		public Pair(long a, long t) {
			super();
			this.a = a;
			this.t = t;
		}
	}
	static int solve3(List<List<Long>> profits) {
		/*Pair[] profitsArr = new Pair[profits.size()];
		int c = 0;
		for (List<Long> eachDay : profits) {
			profitsArr[c++] = new Pair(eachDay.get(0).longValue(), eachDay.get(1).longValue());
		}*/
		
		long pendingFromYesterday = 0;
		// for (Pair p :  profitsArr) {
		for (List<Long> p :  profits) {
			long actual = p.get(0).longValue();
			long target = p.get(1).longValue() + pendingFromYesterday;
			
			if (target > actual) {
				pendingFromYesterday = target - actual;
			} else {
				pendingFromYesterday = 0;
			}
		}
		return pendingFromYesterday > 0 ? 1 : 0;
	}
}
