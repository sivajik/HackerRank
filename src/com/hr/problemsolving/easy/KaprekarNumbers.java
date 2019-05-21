package com.hr.problemsolving.easy;

public class KaprekarNumbers {

	public static void main(String[] args) {
		kaprekarNumbers(1, 99999);
		// 77778 82656 95121 99999
		// long x = 77778;
		// System.out.println( (x * x));
		// System.out.println((int) (x * x));
		// System.out.println(isKaprekar(77778));

	}

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		boolean found = false;
		for (int i = p; i <= q; i++) {
			if (isKaprekar(i)) {
				System.out.print(i + " ");
				found = true;
			}
		}

		if (!found) {
			System.out.print("INVALID RANGE");
		}
	}

	static boolean isKaprekar(int num) {
		long squareOfNumber = ((long) num * (long) num); // 55 * 55 -> 3025

		int d = totalDigits(num);
		int sqNumDigits = totalDigits(squareOfNumber);

		// System.out.println("Total digits: " + d);
		// System.out.println("Total digits in Squared Number: " + sqNumDigits);
		// System.out.println("Square: " + squareOfNumber);

		long temp = squareOfNumber;
		int rightPart = 0;
		for (int i = 0; i < d; i++) {
			int x = (int) (temp % 10);
			rightPart = rightPart + (x * (int) Math.pow(10, i));
			temp = temp / 10;
		}

		temp = squareOfNumber;
		for (int i = 0; i < d; i++) {
			temp = temp / 10;
		}
		int leftPart = (int) temp;

//		if (leftPart + rightPart == num) {
//			System.out.println(
//					"Split : " + leftPart + " + " + rightPart + " => " + (leftPart + rightPart) + " == " + num);
//		}
		return leftPart + rightPart == num;
	}

	static int totalDigits(int num) {
		int count = 0;
		while (num > 0) {
			num /= 10;
			count++;
		}
		return count;
	}

	static int totalDigits(long num) {
		int count = 0;
		while (num > 0) {
			num /= 10;
			count++;
		}
		return count;
	}
}
