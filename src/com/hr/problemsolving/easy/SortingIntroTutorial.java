package com.hr.problemsolving.easy;

public class SortingIntroTutorial {

	public static void main(String[] args) {
		int[] a = {1 ,4, 5, 7, 9, 12};
		System.out.println(introTutorial(4, a));
	}
	
    static int introTutorial(int V, int[] arr) {
    	return performBinarySearch(arr, V, 0, arr.length - 1);
    }

    static int performBinarySearch(int[] arr, int lookFor, int p, int r) {
    	if (p <= r) {
    		int mid = (p + r) / 2;//p + (r-p) / 2;
    		if (arr[mid] == lookFor) {
    			return mid;
    		} else if (lookFor < arr[mid]) {
    			return performBinarySearch(arr, lookFor, p, mid - 1);
    		} else {
    			return performBinarySearch(arr, lookFor, mid + 1, r);
    		}
    	} else {
    		return -1;
    	}
    }
}
