package com.hr.problemsolving.easy;

public class ShrelockSquares {

	public static void main(String[] args) {
		System.out.println(squares(465868129 ,988379794));
		// System.out.println(squares(17, 24));
		// System.out.println(squares(24, 49));
	}

	// Complete the squares function below.
	static int squares(int a, int b) {
		return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
	}
}
