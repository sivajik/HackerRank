package com.hr.problemsolving.easy;

public class TimeConversion {

	public static void main(String[] args) {
		System.out.println(timeConversion("07:05:45PM"));
		System.out.println(timeConversion("12:05:45AM"));
		System.out.println(timeConversion("12:05:45PM"));
		System.out.println(timeConversion("02:00:45PM"));
		System.out.println(timeConversion("06:40:03AM"));
		

	}
    static String timeConversion(String s) {
    	String milTime = "";
    	String hrsStr = s.substring(0, 2);
    	if (s.endsWith("AM")) {
    		if (hrsStr.equals("12")) {
    			milTime = "00" + s.substring(2);
    		} else {
    			milTime = s;
    		}
    	} else if (s.endsWith("PM")) {
    		int hrs = Integer.parseInt(hrsStr);
    		hrs += hrs == 12 ? 0 : 12;
    		milTime = hrs + s.substring(2); 
    	}
    	return milTime.substring(0, milTime.length() - 2);
    }
}
