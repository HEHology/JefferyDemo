package com.seakie;

import java.util.ArrayList;
import java.util.Scanner;

public class C2012 {

	public static void q1SpeedFine() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the speed limit:");
		int limit = sc.nextInt();
		System.out.print("Enter the recorded speed of the car:");
		int speed = sc.nextInt();

		if (limit + 1 <= speed && speed <= limit + 20){
			System.out.println("You are speeding and your fine is $100.");
		} else if (limit + 21 <= speed && speed <= limit + 30){
			System.out.println("You are speeding and your fine is $270.");
		} else if (speed >= limit + 31) {
			System.out.println("You are speeding and your fine is $500.");
		} else {
			System.out.println("Congratulations, you are within the speed limit!");
		}
		sc.close();
	}
 	public static void q2Fishy() {
 		Scanner sc = new Scanner(System.in);
 		ArrayList<Integer> levels = new ArrayList<Integer>();
 		for (int index = 0; index < 4; index++){
 			levels.add(sc.nextInt());
 		}

 		if (levels.get(1) > levels.get(0)
 		 && levels.get(2) > levels.get(1)
 		 && levels.get(3) > levels.get(2)) {
 			System.out.println("Fish Rising");
 		} else if (levels.get(1) < levels.get(0)
 		 		 && levels.get(2) < levels.get(1)
 		 		 && levels.get(3) < levels.get(2)) {
 			System.out.println("Fish Diving");
 		} else if (levels.get(1) == levels.get(0)
		 		 && levels.get(2) == levels.get(1)
		 		 && levels.get(3) == levels.get(2)) {
			System.out.println("Fish At Constant Depth");
		} else {
			System.out.println("No Fish");
		}
 		
 		sc.close();
 	}
 	public static void q4BigBang() {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder(str);
		for (int p = 0; p < sb.length(); p++) {
			char ch = sb.charAt(p);
			int shift = 3 * (p + 1) + K;
//			System.out.println(shift + " for " + ch);
			if (ch - shift < 'A')
			{
				ch += 26;
			}
			ch = (char) (ch - shift);
			sb.setCharAt(p, ch);
		}
		
		System.out.println(sb);
		sc.close();
	}
	public static void q3Icon() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.close();
		
		int edge = 3 * size;
		for (int row = 0; row < edge; row++){
			for (int col = 0; col < edge; col++){
//				System.out.print("#");
				int state = getState(row, col, size);
				switch (state) {
				case 0:
					System.out.print("*");
					break;
				case 1:
					System.out.print("x");
					break;
				case 2:
					System.out.print(" ");
					break;
				default:
					break;
				}
			}
			System.out.println();
		}
	}
	private static int getState(int row, int col, int size) {
		int regin = (row / size) * 3 + (col / size);
		if (regin == 0 || regin == 2 || regin == 6 || regin == 8)
			return 0;
		
		if (regin == 1 || regin == 4 || regin == 5)
			return 1;

		if (regin == 3 || regin == 7 )
			return 2;
		return -1;
	}
	private static int getStateDumb(int row, int col, int size) {
		int regin = 0;
		
		if ((0 <= row && row < size) && (0 <= col && col < size))
			regin = 0;
		if ((0 <= row && row < size) && (size <= col && col < 2 * size))
			regin = 1;
		if ((0 <= row && row < size) && (2 * size <= col && col < 3 * size))
			regin = 2;
			
		if ((size <= row && row < 2 * size) && (0 <= col && col < size))
			regin = 3;
		if ((size <= row && row < 2 * size) && (size <= col && col < 2 * size))
			regin = 4;
		if ((size <= row && row < 2 * size) && (2 * size <= col && col < 3 * size))
			regin = 5;
			
		if ((2 * size <= row && row < 3 * size) && (0 <= col && col < size))
			regin = 6;
		if ((2 * size <= row && row < 3 * size) && (size <= col && col < 2 * size))
			regin = 7;
		if ((2 * size <= row && row < 3 * size) && (2 * size <= col && col < 3 * size))
			regin = 8;

		if (regin == 0 || regin == 2 || regin == 6 || regin == 8)
			return 0;
		
		if (regin == 1 || regin == 4 || regin == 5)
			return 1;

		if (regin == 3 || regin == 7 )
			return 2;
		
		return -1;
	}
}
