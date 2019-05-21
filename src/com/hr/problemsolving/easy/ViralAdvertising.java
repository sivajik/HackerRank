package com.hr.problemsolving.easy;

public class ViralAdvertising {

	public static void main(String[] args) {
		System.out.println(viralAdvertising(3));

	}
    static int viralAdvertising(int n) {
    	int shared = 5;
    	int liked = 2;
    	int cumulativeLiked = liked;
    	
    	for (int i = 2; i <= n; i++) {
    		int todaysShared = liked * 3;
    		liked = todaysShared / 2;
    		cumulativeLiked += liked;
    	}
    	return cumulativeLiked;
    }
}
