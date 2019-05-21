package com.hr.problemsolving.medium;


/*
considering that you have stored the means and all the values in two arrays you can start the traversel 
of array for the mean from the middle to some values near by in say from 

mid to mid+k and mid-k to search 
the value. 

Make sure mean array is sorted. 

k is the number you have to guess. this will reduce the iterations.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeanNormal4 {

	
	  public static void main(String[] args) { 
		  ArrayList<Long> l = new ArrayList<Long>(); 
		  l.add(1l); l.add(3l); l.add(4l); l.add(11l); l.add(10l); // 4
	  
	   solve(new double[]{ (double) (1.0+3.0+4.0) / 3.0, 10.5}, l);

	   
		  // 1 3 4 10 11
	  System.out.println("\n\n====\n");
	  
	  ArrayList<Long> m = new ArrayList<Long>(); 
	  m.add(2l); m.add(55l); m.add(3l); m.add(13l); 
	  
	  m.add(1l);
	  m.add(20l);
	  m.add(20l);
	  m.add(22l);
	  
	  solve(new double[]{(double)(2l+55l+3l+13l) / 4, (double) (1l) / 1, (double) (20l + 20l + 22l) / 3}, m);
	  
 	  }
 

	/*

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// Capture while reading itself..
		double[] means = new double[n];
		List<Long> l = new ArrayList<Long>();

       for (int a0 = 0; a0 < n; a0++) {
			int m_i = in.nextInt();
			
			long[] p_i = new long[m_i];
			long sum = 0l;
			for (int g = 0; g < m_i; g++) {
				p_i[g] = in.nextLong();
				sum += (double) p_i[g];
				l.add(p_i[g]);
			}
			means[a0] = (double) (sum) / p_i.length;
		}
		solve(means, l);

		in.close();
	}
*/

	  static int numOfElemLessThan(long arr[], int n, double meanThisTime) 
	  {
	      int left = 0, right = n;
	   
	      int mid = 0;
	      while (left < right) {
	      mid = left + (right - left) / 2;
	   
	      // Check if key is present in array
	      if (arr[mid] == meanThisTime) {
	          // If duplicates are present it returns
	          // the position of last element
	          while (arr[mid + 1] == meanThisTime && mid + 1 < n)
	          mid++;
	          break;
	      }
	   
	      // If key is smaller, ignore right half
	      else if (arr[mid] > meanThisTime)
	          right = mid;
	   
	      // If key is greater, ignore left half
	      else
	          left = mid + 1;
	      }
	   
	      // If key is not found in array then it will be
	      // before mid
	      while (arr[mid] > meanThisTime)
	      mid--;
	   
	      // Return mid + 1 because of 0-based indexing
	      // of array
	      return mid + 1;
	  }
	  
	  static void solve(double[] means, List<Long> l) {
			Arrays.sort(means);
			
			long[] P = new long[l.size()];
			int counter = 0;
			for (Long elem : l) {
				P[counter] = elem;
				counter++;
			}
			Arrays.sort(P);
			
			long[] Q = new long[l.size()];
			Q[0] = P[0];
			for (int i = 1; i < Q.length; i++) {
				Q[i] = P[i] + Q[i-1]; 
			}
			
			double min = Double.MAX_VALUE;
			
			for (double meanThisTime : means) {
				int x = numOfElemLessThan(P, P.length-1, meanThisTime);
				if (x > 0) {
					double val = x * meanThisTime -
								Q[x-1] +
								(Q[Q.length -1] - Q[x-1] ) -
								( Q.length - x) * meanThisTime;
					if (val < min) {
						min = val;
					}
				}
			}
			System.out.printf("%.10f", min);
		}
}