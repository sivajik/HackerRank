package com.hr.problemsolving.easy;

public class TimeInWords {

	public static void main(String[] args) {
		/*System.out.println(timeInWords(5, 00));
		System.out.println(timeInWords(5, 1));
		System.out.println(timeInWords(5, 10));
		System.out.println(timeInWords(5, 15));
		System.out.println(timeInWords(5, 30));
		System.out.println(timeInWords(5, 40));
		System.out.println(timeInWords(5, 45));
		System.out.println(timeInWords(5, 47));
		System.out.println(timeInWords(5, 28));*/
		System.out.println(timeInWords(1, 1));

	}

	static String timeInWords(int h, int m) {
		String[] hours = { "XXX", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve" };

		String[] doubles = { "XXX", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };

		String[] more = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		String time = "";
		if (m == 0) {
			return hours[h] + " o' clock";
		} else if (m >= 1 && m <= 30) {
			if (m == 15) {
				return "quarter" + " past " + hours[h];
			} else if (m == 30) {
				return "half" + " past " + hours[h];
			} else {
				if ( m == 1) {
					return minutes(m) + " minute past " + hours[h];

				} else {
					return minutes(m) + " minutes past " + hours[h];
				}
			}
		} else if (m > 30) {
			if (m == 45) {
				return "quarter" + " to " + hours[h + 1];
			} else {
				int leftOverMin = 60 - m;
				return minutes(leftOverMin) + " minutes to " + hours[h+1];
			}
		}
		return "";
	}

	static String minutes(int m) {
		String[] singles = { "XXX", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve" };

		String[] doubles = { "XXX", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };

		String[] more = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		if (m >= 1 && m <= 10) {
			return singles[m];
		} else if (m >= 11 && m <= 19) {
			return doubles[m - 10];
		} else {
			if (m % 10 == 0) {
				return more[ m / 10];
			} else {
				return more[m / 10] + " " + singles[m % 10]; 
			}
		}
	}
}
