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
}
