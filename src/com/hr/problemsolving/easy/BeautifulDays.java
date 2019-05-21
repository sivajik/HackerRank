package com.hr.problemsolving.easy;

public class BeautifulDays {

	public static void main(String[] args) {
		System.out.println(beautifulDays(20, 23, 6));
	}

	static int beautifulDays(int i, int j, int k) {
		int totalDays = 0;
		for (int counter = i; counter <= j; counter++) {
			if (isBeautifulDay(counter, k)) {
				System.out.println("Beautiful : " + counter);
				totalDays++;
			}
		}
		return totalDays;
	}

	private static boolean isBeautifulDay(int num, int divisor) {
		int rev = reverse(num);
		int diff = Math.abs(rev - num);
		if (diff == 0) {
			return true;
		} else if (diff % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static int reverse(int num) {
		if (num == 0) {
			return 0;
		} else {
			int revNu = 0;
			int x = 0;
			while (num > 0) {
				x = num % 10;
				revNu = revNu * 10 + x;
				num = num / 10;
			}
			return revNu;
		}
	}
}
