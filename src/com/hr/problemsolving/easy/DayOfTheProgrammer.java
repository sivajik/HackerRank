package com.hr.problemsolving.easy;

public class DayOfTheProgrammer {

	public static void main(String[] args) {
		System.out.println(dayOfProgrammer(2017));
		System.out.println(dayOfProgrammer(2016));
		System.out.println(dayOfProgrammer(1800));

	}

	static String dayOfProgrammer(int year) {
		if (year > 2700 || year < 1700) {
			throw new RuntimeException("Invalid input");
		}
		int febDays = isLeapYear(year) ? 29 : 28;

		int daysUntil8Months = -1;

		if (isGregorian(year) || isJulian(year)) {
			daysUntil8Months = 31 + febDays + 31 + 30 + 31 + 30 + 31 + 31;
		} else {
			daysUntil8Months = 31 + 15 + 31 + 30 + 31 + 30 + 31 + 31;
		}

		int days = 256 - daysUntil8Months;

		String daysStr = String.format("%02d", days);
		String month = String.format("%02d", 9);
		return daysStr + "." + month + "." + year;
	}

	static boolean isLeapYear(int year) {
		if (year >= 1700 && year <= 1917) {
			return year % 4 == 0;
		} else if (year == 1918) {
			return false;
		} else {
			return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		}
	}

	static boolean isJulian(int year) {
		return (year >= 1700 && year <= 1917);
	}

	static boolean isGregorian(int year) {
		return year >= 1919;
	}

	static boolean is2018(int year) {
		return year == 2018;
	}

}
