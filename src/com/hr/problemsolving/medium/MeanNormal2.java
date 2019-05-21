package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeanNormal2 {

	
	  public static void main(String[] args) { 
		  ArrayList<Long> l = new ArrayList<Long>(); 
		  l.add(1l); l.add(3l); l.add(4l); l.add(11l); l.add(10l);
	  // 1 3 4 11 10
	   solve(new double[]{2.666666666666667, 10.5}, l);
	      // 0  1   2  3   4  5   6   7
		  // 2, 55, 3, 13, 1, 20, 20, 22
	  System.out.println("\n\n====\n");
	  
	  ArrayList<Long> m = new ArrayList<Long>(); 
	  m.add(2l); m.add(55l); m.add(3l); m.add(13l); 
	  
	  m.add(1l);
	  
	  m.add(20l);
	  m.add(20l);
	  m.add(22l);
	  
	  solve(new double[]{18.25, 1, 20.666666666666667}, m /*, new long[] {
			  {2, 55, 3, 13},
			  {1},
			  {20, 20, 22}
	  }*/);
   

	  }
 
	  static double forGivenMean(double meanThisTime, List<Long> l) {
		  System.out.println(l + "  mean: " + meanThisTime);
		 
		  double result = 0.0d;
		  long size = 0;//l.size() - 1;
		  while (size < l.size() / 2) {
			  result += Math.abs(l.get((int) (size)) - meanThisTime);
					  size = size + 1;
		  }
		  System.out.println("Temp sum: " + result);
		  return result ;
			  /*Math.abs(l.get(0) - meanThisTime)
					  +
					  Math.abs(l.get(l.size() / 2) - meanThisTime)
					  +
					  Math.abs(l.get(l.size() - 1) - meanThisTime);
					  */ 
	  }
	  

	  
	  
	  static void solve(double[] means, List<Long> l) {
			double sum = 0.0d;

			double min = Double.MAX_VALUE;
			double x = 0;
			for (double meanThisTime : means) {
				double sumInter = forGivenMean(meanThisTime, l);
				if (sumInter < min) {
					min = sumInter;
					x = meanThisTime;
				}
			}
			
			System.out.println("Final mean selected: " + x);
			for (Long elem : l) {
					sum += Math.abs(x - elem.longValue());
			}
			System.out.printf("%.10f", sum);
		}
	  
/*	  static void solve(double[] means, List<Long> l) {
			double sum = 0.0d;
			boolean minOnceFound = false;
			double min = Double.MAX_VALUE;

			Collections.sort(l);
			
			for (double meanThisTime : means) {
				for (int i = 0; i < l.size() /2; i++) {
					sum  +=  (
								Math.abs(meanThisTime - l.get(i).longValue())
								+
								Math.abs(meanThisTime - l.get(i + (l.size()/2)).longValue())
							);

					if (minOnceFound) {
						if (sum > min) {
							break;
						}
					}
				}
				
				if (sum < min && l.size() % 2 != 0) {
					sum += Math.abs(l.get(l.size() - 1) - meanThisTime);
				}
				
				System.out.println("current sum: " + sum);
				if (sum < min) {
					min = sum;
					minOnceFound = true;
				}
				sum = 0.0d;
			}
			System.out.printf("%.10f", min);
		}
	 */ 
	
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
				sum += p_i[g];
				l.add(p_i[g]);
			}
			means[a0] = (double) (sum) / p_i.length;
		}
		solve(means, l);

		in.close();
	}
*/
	  
	  
	  /*static void solve(double[] means, List<Long> l) {
			double sum = 0.0d;

			Collections.sort(l);
			
			double min = Double.MAX_VALUE;
			double x = 0;
			for (double meanThisTime : means) {
				double sumInter = forGivenMean(meanThisTime, l);
				if (sumInter < min) {
					min = sumInter;
					x = meanThisTime;
				}
			}
			
			System.out.println("Final mean selected: " + x);
			for (Long elem : l) {
					sum += Math.abs(x - elem.longValue());
			}
			System.out.printf("%.10f", sum);
		}*/
	  
	  
	  static void solve12(long[][] values, List<Long> l) {
			double sum = 0.0d;
			boolean minFound = false;
			double min = Double.MAX_VALUE;

			long[] P = new long[l.size()];
			for ( int i = 0; i < l.size(); i++) {
				P[i] = l.get(i).longValue();
			}
			
			Arrays.sort(P);
			
			long median = 0l;
			if (P.length % 2 == 0) {
				median = ( P[P.length / 2] + P[1 + (P.length / 2)]) / 2;
			} else {
				median = P[P.length / 2];
			}
			System.out.println("Median : " + median);
			
				for (int i = 0 ; i < l.size(); i++) {
					Long elem = l.get(i);
					
					sum  += Math.abs(median - elem.longValue());

					if (sum < min) {
						min = sum;
						minFound = true;
					}
				}
		
			System.out.printf("%.10f", sum);
		}
	  
	  
	  static void solve11(long[] means, List<Long> l) {
			double sum = 0.0d;
			boolean minFound = false;
			double min = Double.MAX_VALUE;

			long[] P = new long[l.size()];
			for ( int i = 0; i < l.size(); i++) {
				P[i] = l.get(i).longValue();
			}
			
			Arrays.sort(P);
			
			long median = 0l;
			if (P.length % 2 == 0) {
				median = ( P[P.length / 2] + P[1 + (P.length / 2)]) / 2;
			} else {
				median = P[P.length / 2];
			}
			System.out.println("Median : " + median);
			
				for (int i = 0 ; i < l.size(); i++) {
					Long elem = l.get(i);
					
					sum  += Math.abs(median - elem.longValue());

					if (sum < min) {
						min = sum;
						minFound = true;
					}
				}
		
			System.out.printf("%.10f", sum);
		}
	  
	  
	static void solve3(double[] means, List<Long> l) {
		double sum = 0.0d;
		boolean minFound = false;
		double min = Double.MAX_VALUE;

		for (double meanThisTime : means) {
			for (int i = 0 ; i < l.size(); i++) {
				Long elem = l.get(i);
				
				double currSum = Math.abs(meanThisTime - elem.longValue());

				if (minFound && currSum > min) {
					break;
				} else {
					sum += currSum;
					if (sum > min) {
						break;
					}
				}
			}
			
			// System.out.println("current sum: " + sum);
			if (sum < min) {
				min = sum;
				minFound = true;
			}
			sum = 0.0d;
		}
		System.out.printf("%.10f", min);
	}
	  
	  
	/*  
	  static void solve(double[] means, List<Long> l) {
			double sum = 0.0d;
			boolean minFound = false;
			double min = Double.MAX_VALUE;

			for (double meanThisTime : means) {
					for (Long elem : l) {
					sum  +=  Math.abs(meanThisTime - elem.longValue());

					if (minFound) {
						if (sum > min) {
							break;
						}
					}
				}
				
				System.out.println("current sum: " + sum);
				if (sum < min) {
					min = sum;
					minFound = true;
				}
				sum = 0.0d;
			}
			System.out.printf("%.10f", min);
		}
*/
	  
		
		
		
}