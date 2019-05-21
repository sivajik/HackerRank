package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.List;

public class GapupGapDowb {

	public static void main(String[] args) {
		List<Integer> low = new ArrayList<Integer>();
		low.add(2);
		low.add(8);
		low.add(6);
		low.add(12);
		
		
		List<Integer> h = new ArrayList<Integer>();
		h.add(10);
		h.add(15);
		h.add(13);
		h.add(20);
		//h.add(10);
		
		List<Integer> c = new ArrayList<Integer>();
		c.add(6);
		c.add(12);
		c.add(11);
		c.add(6);
		//c.add(6);
		
		solve(low, h, c);

	}

	static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {
		int n = low.size();
		int up = 0;
		int down = 0;
		for (int i = 1; i < n; i++) {
			int closing = close.get(i - 1);
			int highest = high.get(i);
			int lowest = low.get(i);

			if (highest < closing) {
				down++;
			}
			if (lowest > closing) {
				up++;
			}
		}
		System.out.println(up + " " + down);
	}
}
