package com.hr.problemsolving.easy;

public class CatAndMouse {

	public static void main(String[] args) {
		System.out.println(catAndMouse(2, 5, 4));

	}
    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
    	if ( Math.abs(x - z) > Math.abs(y - z)) {
    		return "Cat B";
    	} else if ( Math.abs(x - z) < Math.abs(y - z)) {
    		return "Cat A";
    	} else {
    		return "Mouse C";
    	}
    }
}