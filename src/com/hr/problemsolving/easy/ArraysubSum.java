package com.hr.problemsolving.easy;

public class ArraysubSum {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 7, 5, 9, 0 };
		int sum = 12;

		int leftPointer = 0;
		int rightPointer = 1;
		int runningSum = a[leftPointer] + a[rightPointer];

		for (; leftPointer < a.length;) {
			if (runningSum == sum) {
				System.out.println("We have met the condition. " + leftPointer + " -> " + rightPointer);
				
				leftPointer = leftPointer + 1;
				rightPointer = leftPointer + 1;
				if (leftPointer == a.length || rightPointer == a.length) {
					break;
				} else {
					runningSum = a[leftPointer] + a[rightPointer];
				}
				
				//break;
			} else if (runningSum < sum && rightPointer+1 < a.length) {
				rightPointer = rightPointer + 1;
				runningSum += a[rightPointer];
			} else {
				leftPointer = leftPointer + 1;
				rightPointer = leftPointer + 1;
				if (leftPointer == a.length || rightPointer == a.length) {
					break;
				} else {
					runningSum = a[leftPointer] + a[rightPointer];
				}
			}
		}
	}
}