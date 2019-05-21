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

public class MeanNormal3 {

	
	  public static void main(String[] args) { 
		/*  ArrayList<Long> l = new ArrayList<Long>(); 
		  l.add(1l); l.add(3l); l.add(4l); l.add(11l); l.add(10l); // 4
	  
	   solve(new double[]{ (double) (1.0+3.0+4.0) / 3.0, 10.5}, l);

	   
		  // 1 3 4 10 11
	  System.out.println("\n\n====\n");
	  */
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

	  static int numOfElemLessThan (long[] P, double meanThisTime) {
//		  if ( p <= r) {
//			  int mid = p + ( r - p) /2;
//			  if ( a[mid] > meanThisTime) {
//				  numOfElemLessThan(P, meanThisTime, p, mid - 1);
//			  } else if ( a[mid] < meanThisTime) {
//				  numOfElemLessThan(P, meanThisTime, p, mid - 1);
//			  }  
//		  }
		  int count = 0;
		  for (int i = 0; i < P.length; i++) {
			  if (P[i] < meanThisTime) {
				  count++;
			  }
		  }
		  return count;
	  }
	  
	  
	  static double binarySearch(double[] arr, int p, int r, double lookFor) {
			if (p <= r) {
				int mid = p + (r - p) / 2;
				if (arr[mid] == lookFor) {
					return lookFor;
				} else if (lookFor < arr[mid]) {
					return binarySearch(arr, p, mid - 1, lookFor);
				} else if (lookFor > arr[mid]) {
					return binarySearch(arr, mid + 1, r, lookFor);
				}
			}
			return -1;
		}
	  
	  static double meanOfValue(long[] P, int start, int end) {
		  double sum = 0.0d;
		  for (int index = start; index <= end; index++) {
			  sum += P[index];
		  }
		  double result = (double) sum / (end - start + 1);
		  System.out.println("Mean : " + result);
		  return result;
	  }
	  
	  
	  static void solve(double[] means, List<Long> l) {
			Arrays.sort(means);
			System.out.println(Arrays.toString(means));
			
			long[] P = new long[l.size()];
			int counter = 0;
			for (Long elem : l) {
				P[counter] = elem;
				counter++;
			}
			Arrays.sort(P);
			System.out.println(Arrays.toString(P));
			
			
			/*
So, if we are using the example, prices = [1,2,3,13,20,20,22,55], 
means = [2.7, 18.25, 20.7], 
and preFixSum = [1,3,6,19,39,59,81,136], 

and suppose we are on currMean = 18.25. 

We would get the following: 4(18.25) - 19 + 136 - 19 + 4(18.25) = 244?
			 */
			long[] Q = new long[l.size()];
			Q[0] = P[0];
			for (int i = 1; i < Q.length; i++) {
				Q[i] = P[i] + Q[i-1]; 
			}
			
			System.out.println(Arrays.toString(Q));
			
			double min = Double.MAX_VALUE;
			
			for (double meanThisTime : means) {
				int x = numOfElemLessThan(P, meanThisTime);
				System.out.print("mean : " + meanThisTime + "  count : " + x);
				if (x > 0) {
					double val = x * meanThisTime -
								Q[x-1] +
								(Q[Q.length -1] - Q[x-1] ) -
								( Q.length - x) * meanThisTime;
					System.out.println("  and value = " + val);
//					double val = 3X- (n0+n1+n3) + (n3+n4+...+n99) - (100-3)X
/*
 X-n0 + X - n1 + X - n2 + (n3-X) + (n4-X) + ... + (n99 - X)
which can then be rewritten as follows
3X- (n0+n1+n2) + (n3+n4+...+n99) - (100-3)X
so if you store the prefix sums it can be done easilly
hope you people are getting the idea

x*currMean - prefixSum[x] + (prefixSum[N] - prefixSum[x]) + (N-x)*currMean


 */
					if (val < min) {
						min = val;
					}
				}
				System.out.println();

			}
			System.out.printf("%.10f", min);
			/*
			int k = 1;
			int start = P.length / 2;

			while (start - k >=0 && start + k < P.length) {
				//System.out.println("Current K = " + k);
				 // if ( start - k >= 0) {
					 double meanThisTime = binarySearch(means, 0, means.length - 1, meanOfValue(P, start -k, start));
						if ( meanThisTime != -1) {
							System.out.println("Found ==== " + meanThisTime);
							// found the means;
							double sum = 0;
							for (Long elem : l) {
								sum += Math.abs(meanThisTime - elem.longValue());
							}
							System.out.printf("%.10f", sum);
							return;
						}
				 //}
				
				//if (start + k < P.length) {
					 meanThisTime = binarySearch(means, 0, means.length - 1, meanOfValue(P, start, start+k));
					if ( meanThisTime != -1) {
						System.out.println("Found ==== " + meanThisTime);
						// found the means;
						double sum = 0;
						for (Long elem : l) {
							sum += Math.abs(meanThisTime - elem.longValue());
						}
						System.out.printf("%.10f", sum);
						return;
					}	
				//}
				
				k++;
			}*/
			
		}
}