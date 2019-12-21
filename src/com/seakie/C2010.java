package com.seakie;

import java.util.Scanner;

public class C2010 {

	public static void q1WhatIs() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		for (int i = 0; i <= 5; i ++) {
			for (int j = i; j <= 5; j++) {
				if (i + j == input) {
					System.out.print(input + " is ");
					if (j != 0)
						System.out.print(j);
					if (i != 0 )
						System.out.print(" and " + i);
					System.out.println();
				}
			}
		}
		scan.close();
	}

	public static void q2UpAndDown() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int s = scan.nextInt();
		
		int temp = s;
		int NikkyPos = 0;
		while (true) {
			temp -= a;
			NikkyPos += a;
			if (temp <= 0)
				break;
			
			temp -= b;
			NikkyPos -= b;
			if (temp <= 0)
				break;
		}
		
		temp = s;
		int ByronPos = 0;
		while (true) {
			temp -= c;
			ByronPos += c;
			if (temp <= 0)
				break;
			
			temp -= d;
			ByronPos -= d;
			if (temp <= 0)
				break;
		}
		
		if (NikkyPos > ByronPos){
			System.out.println("Nikky");
		} else {
			System.out.println("Byron");
		}

		scan.close();
	}

}
