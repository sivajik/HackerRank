package com.hr.problemsolving.easy;

public class Kangaroo {

	public static void main(String[] args) {
		System.out.println(kangaroo(0, 2, 5, 3));

	}
    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
    	for (int i = 0; i < 10000; i++) {
    		x1 = x1 + v1;
    		x2 = x2 + v2;
    		
    		if ( x1 == x2) {
    			System.out.println("After " + (i+1) + " jumps");
    			return "YES";
    		}
    	}
    	
    	return "NO";
    }
}
