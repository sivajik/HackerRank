package com.hr.problemsolving.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BonApetite {

	public static void main(String[] args) {
		List<Integer> bill = Arrays.asList(3, 10, 2, 9);
		bonAppetit(bill, 1, 12);
	}

	// Complete the bonAppetit function below.
	static void bonAppetit(List<Integer> bill, int k, int b) {
		int totalSum = 0;
		Iterator<Integer> itr = bill.iterator();
		while (itr.hasNext()) {
			totalSum += itr.next();
		}
		
		int bActual = (totalSum - bill.get(k)) / 2;
		
		if (bActual == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println((int) Math.abs(bActual - b));
		}

	}
}
