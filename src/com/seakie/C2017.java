package com.seakie;

import java.util.Scanner;

public class C2017 {
	private static Scanner scan = new Scanner(System.in);

	public static void q4() {
		int[] time = new int[3];
		time[0] = 12;
		time[1] = 0;
		time[2] = 0;
		
		int result = 0;
//		print(time);
		
		int pass = 180;
		for (int i = 0; i <= pass; i++){
//			print(time);
			if (q4isSeq(time)) {
//				print(time);
				result ++;
			}
//			System.out.println(i);
			q4increase(time);
		}
		
		System.out.println(result);
	}

	private static boolean q4isSeq(int[] time) {
		int hourH = time[0] / 10;
		int hourL = time[0] % 10;
		int diff = 0;
		if (hourH > 0) 
			diff = hourH - hourL;
		else
			diff = hourL - time[1];
		
		if ((hourL - time[1] == diff)
			&& (time[1] - time[2] == diff)) {
			return true;
		}
		return false;
	}

	private static void q4increase(int[] time) {
		time[2] ++;
		if (time[2] >= 10) {
			time[2] = 0;
			time[1]++;
		}
		if (time[1] >= 6) {
			time[1] = 0;
			time[0]++;
		}
		if (time[0] >= 13) {
			time[0] = 1;
		}
	}

	private static void q4print(int[] time) {
		System.out.print(time[0]);
		System.out.print(":");
		System.out.print(time[1]);
		System.out.println(time[2]);
	}


	public static void q1QuadSection() {
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		if (x > 0 && y > 0)
			System.out.println(1);
		if (x > 0 && y < 0)
			System.out.println(4);
		if (x < 0 && y > 0)
			System.out.println(2);
		if (x < 0 && y < 0)
			System.out.println(3);
	}

	public static void q2Shift() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int result = 0;
		
		for (int i = 0; i <= k; i++){
			result += n;
			n *= 10;
		}
		
		System.out.println(result);
	}

	public static void q3ExactlyElectrical() {
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		
		int dist = scan.nextInt();
		
		int far = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		if (far > dist)
			System.out.println("N");
		else if ((dist - far) % 2 == 1)
			System.out.println("N");
		else
			System.out.println("Y");
	}

}
