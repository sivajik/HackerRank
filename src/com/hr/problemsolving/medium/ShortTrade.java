package com.hr.problemsolving.medium;

import java.util.Arrays;

/*
ust consider for current person what should be the range. then check for some value is there any possible solution? and add that if found
for example a = 5  m = 3
for the first person we can consider 1 to 5
if we consider 5 then the next person can only give in the range 1 to 4



 */
public class ShortTrade {
	public static void main(String[] args) throws Exception {
		int S = 3, K = 2;
		System.out.println("S=" + S + "   K=" + K);
		//System.out.println(PartionwithZero(S, K));
		 System.out.println(PartionwithoutZero(S, K));
		// System.out.println(PartionwithZeroUnique(S, K));
	}

	/* Divide S in K parts 0 may be present */
	public static long PartionwithZero(int a, int m) {
		long DP_Table[][] = new long[m][];
		for (int i = 0; i < m; i++)
			DP_Table[i] = new long[a + 1];
		
		for (int i = 0; i < a + 1; i++)
			DP_Table[0][i] = Long.MIN_VALUE;
		
		for (int i = 0; i < m; i++)
			DP_Table[i][0] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < a + 1; j++) {
				DP_Table[i][j] = Math.max(0, DP_Table[i - 1][j] + DP_Table[i][j - 1]);
			}
		}
/*
		for(long i=0;i<m;i++) { 
			for(long j=0;j<a+1;j++) {
				System.out.print(DP_Table[(int) i][(int) j]+" . ");
			}
			System.out.println(); 
		}
*/		
		return (int) DP_Table[m - 1][a];
	}

	/* Divide S in K parts 0 should not be present */
	public static int PartionwithoutZero(int a, int m) {
		long DP_Table[][] = new long[m][a];
		for (int i = 0; i < a; i++)
			DP_Table[0][i] = 1;
		for (int i = 1; i < m; i++)
			DP_Table[i][0] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < a; j++)
				DP_Table[i][j] = DP_Table[i - 1][j - 1] + DP_Table[i][j - 1];
		}

		
		for(int i=0;i<m;i++) { 
			for(int j=0;j<a;j++)
				System.out.print(DP_Table[i][j]+" "); 
			System.out.println(); 
		}
		 
		return (int) DP_Table[m - 1][a - 1];
	}

	/* Divide S in K parts 0 may be present */
	public static int PartionwithZeroUnique(int a, int m) {
		long DP_Table[][][] = new long[m][a + 1][a + 1]; // DP_Table[no of
															// partition][Sum][Maximum
															// value in the
															// partition]

		for (int i = 0; i < m; i++)
			DP_Table[i][0][0] = 1;
		for (int i = 1; i < a + 1; i++) {
			DP_Table[0][i][0] = 0;
			DP_Table[0][i][i] = 1;
		}
		for (int i = 1; i < a + 1; i++)
			DP_Table[0][0][i] = 0;

		for (int i = 0; i < a + 1; i++)
			for (int j = 0; j < i; j++)
				DP_Table[0][i][j] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < a + 1; j++)
				for (int k = 1; k < a + 1; k++) {
					// System.out.println(i+" "+j+" "+k);
					DP_Table[i][j][k] = (k - j) >= 0 ? DP_Table[i - 1][j][k - j] : 0;
				}
			for (int k = 0; k < a + 1; k++) {
				long sum = 0;
				for (int j = 0; j < a + 1; j++) {
					DP_Table[i][j][k] += sum;
					sum = DP_Table[i][j][k];
				}
			}
		}

		/*
		 * for(int i=0;i<K;i++) { System.out.println("K ="+i); for(int j=0;j<S+1;j++) {
		 * for(int k=0;k<S+1;k++) System.out.print(DP_Table[i][j][k]+" ");
		 * System.out.println(); } System.out.println(); System.out.println(); }
		 */
		return (int) DP_Table[m - 1][a][a];
	}
}
