package com.hr.problemsolving.easy;

public class AngryProfessor {

	public static void main(String[] args) {
		System.out.println(angryProfessor(4, new int[] {-1, -3, 4, 2}));
		System.out.println(angryProfessor(2, new int[] {0, -1, 2, 1}));

	}
    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
    	int count = 0;
    	for (int elem : a) {
    		if ( elem <= 0) {
    			count ++;
    		}
    	}
    	System.out.println("Came on time: " + count + " he needs only: " + k);
    	return count >= k ? "NO" : "YES";
    }
}
