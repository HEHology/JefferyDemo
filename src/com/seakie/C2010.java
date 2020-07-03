package com.seakie;

import java.util.Arrays;
import java.util.Scanner;

public class C2010 {

	static int numberA = 0;
	static int numberB = 0;

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

	public static void q3Punchy() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			String line = scan.nextLine();
			String[] segments = line.split(" ");
			
			int state = getState(segments);
			
			if (state == 7) {
				break;
			}
//			System.out.println(Arrays.toString(segments));
			switch (state) {
			case 1:
				setValue(segments);
				break;
			case 2:
				outputValue(segments);
				break;
			case 3:
				addValue(segments);
				break;
			case 4:
				multiplyValue(segments);
				break;
			case 5:
				subValue(segments);
				break;
			case 6:
				divideValue(segments);
				break;

			default:
				break;
			}
		}
		scan.close();
	}

	private static void divideValue(String[] segments) {
		int first = 0;
		int second = 0;
		
		if (segments[1].equals("A")) {
			first = numberA;
		} else if (segments[1].equals("B")) {
			first = numberB;
		}
		if (segments[2].equals("A")) {
			second = numberA;
		} else if (segments[2].equals("B")) {
			second = numberB;
		}
		
		if (segments[1].equals("A")) {
			numberA = first / second;
		} else if (segments[1].equals("B")) {
			numberB = first / second;
		}
	}

	private static void subValue(String[] segments) {
		int first = 0;
		int second = 0;
		
		if (segments[1].equals("A")) {
			first = numberA;
		} else if (segments[1].equals("B")) {
			first = numberB;
		}
		if (segments[2].equals("A")) {
			second = numberA;
		} else if (segments[2].equals("B")) {
			second = numberB;
		}
		
		if (segments[1].equals("A")) {
			numberA = first - second;
		} else if (segments[1].equals("B")) {
			numberB = first - second;
		}
	}

	private static void multiplyValue(String[] segments) {
		int first = 0;
		int second = 0;
		
		if (segments[1].equals("A")) {
			first = numberA;
		} else if (segments[1].equals("B")) {
			first = numberB;
		}
		if (segments[2].equals("A")) {
			second = numberA;
		} else if (segments[2].equals("B")) {
			second = numberB;
		}
		
		if (segments[1].equals("A")) {
			numberA = first * second;
		} else if (segments[1].equals("B")) {
			numberB = first * second;
		}
	}

	private static void addValue(String[] segments) {
		int first = 0;
		int second = 0;
		
		if (segments[1].equals("A")) {
			first = numberA;
		} else if (segments[1].equals("B")) {
			first = numberB;
		}
		if (segments[2].equals("A")) {
			second = numberA;
		} else if (segments[2].equals("B")) {
			second = numberB;
		}
		
		if (segments[1].equals("A")) {
			numberA = first + second;
		} else if (segments[1].equals("B")) {
			numberB = first + second;
		}
	}

	private static void outputValue(String[] segments) {
		if (segments[1].equals("A")) {
			System.out.println(numberA);
		} else if (segments[1].equals("B")) {
			System.out.println(numberB);
		}
	}

	private static void setValue(String[] segments) {
		if (segments[1].equals("A")) {
			numberA = Integer.parseInt(segments[2]);
		} else if (segments[1].equals("B")) {
			numberB = Integer.parseInt(segments[2]);
		}
	}

	private static int getState(String[] segments) {
		return Integer.parseInt(segments[0]);
	}

}
