package com.hr.problemsolving.easy;

public class FindDigits {

	public static void main(String[] args) {
		System.out.println(findDigits(1012));

	}
    static int findDigits(int n) {
    	int count = 0;
    	int original = n;
    	while ( n > 0) {
    		int eachdigit = n % 10;
    		if ( eachdigit != 0 && original % eachdigit == 0) {
    			// System.out.println("Digit: " + eachdigit);
    			count++;
    		}
    		n = n / 10;
    	}
    	return count;
    }
}
