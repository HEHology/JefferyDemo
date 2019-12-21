package com.seakie;

import java.util.Scanner;

public class C2011 {

	public static void q1Alien() {
		Scanner scan = new Scanner(System.in);
		int antennas = 0;
		int eyes = 0;
		System.out.println("How many antennas?");
		antennas = scan.nextInt();
		System.out.println("How many eyes?");
		eyes = scan.nextInt();
		
		if ((antennas >= 3) && (eyes <= 4)) {
			System.out.println("TroyMartian");
		}
		if ((antennas <= 6) && (eyes >= 2)) {
			System.out.println("VladSaturnian");
		}
		if ((antennas <= 2) && (eyes <= 3)) {
			System.out.println("GraemeMercurian");
		}
		
		scan.close();
	}

	public static void q2Ballon() {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int M = scan.nextInt();
		int t = 0;
		int height = 0;
		for (t = 1; t <= M; t++) {
			height = (-6) * t * t * t * t + h * t * t * t + 2 * t * t + t;
			if (height <= 0) 
				break;
		}
		
		if (height > 0) {
			System.out.println("The balloon does not touch ground in the given time.");
		} else {
			System.out.println("The balloon first touches ground at hour:");
			System.out.println(t);
		}
		
		scan.close();
	}

}
