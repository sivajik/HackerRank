package com.hr.problemsolving.easy;

public class StairCase {

	public static void main(String[] args) {
		staircase(6);
		staircase(4);
		staircase(7);
		staircase(1);
		staircase(0);
	}
    static void staircase(int n) {
    	for (int i = 1; i <= n; i++) {
    		for (int j = n; j > 0; j--) {
    			if (j > i ) {
    				System.out.print(' ');
    			} else {
    				System.out.print('#');
    			}
     		}
    		System.out.println();
    	}
    }
}
