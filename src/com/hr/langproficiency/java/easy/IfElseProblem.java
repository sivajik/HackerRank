package com.hr.langproficiency.java.easy;

public class IfElseProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void print (int n) {
		if (n%2 != 0) {
			System.out.println("Weird");
		} else {
			if (n%2 ==0) {
				if (n >=2 && n <= 5) {
					System.out.println("Not Weird");
				} else if (n >= 6 && n <= 20) {
					System.out.println("Weird");
				} else if ( n > 20) {
					System.out.println("Not Weird");
				}
			}
		}
	}
}
