package com.hr.problemsolving.easy;

public class TaumAndBday {

	public static void main(String[] args) {
		System.out.println(taumBday(10, 10, 1, 1, 1)); // 20
		System.out.println(taumBday(5, 9, 2, 3, 4)); // 37
		System.out.println(taumBday(3, 6, 9, 1, 1));// 12
		System.out.println(taumBday(7, 7, 4, 2, 1)); // 35
		System.out.println(taumBday(3, 3, 1, 9, 2)); // 12

		System.out.println(taumBday(27984, 1402, 619246, 615589, 247954)); // 18192035842
		System.out.println(taumBday(95677, 39394, 86983, 311224, 588538)); // 20582630747
		System.out.println(taumBday(68406, 12718, 532909, 315341, 201009)); // 39331944938

		System.out.println(taumBday(15242, 95521, 712721, 628729, 396706)); // 70920116291
		System.out.println(taumBday(21988, 67781, 645748, 353796, 333199)); // 38179353700
		System.out.println(taumBday(22952, 80129, 502975, 175136, 340236)); // 25577754744
		System.out.println(taumBday(38577, 3120, 541637, 657823, 735060)); // 22947138309
		System.out.println(taumBday(5943, 69851, 674453, 392925, 381074)); // 31454478354
		System.out.println(taumBday(62990, 61330, 310144, 312251, 93023)); // 38686324390
		System.out.println(taumBday(11152, 43844, 788543, 223872, 972572)); // 18609275504
	}

	// Complete the taumBday function below.
	static long taumBday(long b, long w, long bc, long wc, long z) {
		if (bc < wc && bc + z <= wc) { // make all black
			return (b + w) * bc + (w * z);
		} else if (wc < bc && wc + z <= bc) { // make all white
			return (b + w) * wc + (b * z);
		} else {
			return (b * bc) + (w * wc);
		}
	}
}