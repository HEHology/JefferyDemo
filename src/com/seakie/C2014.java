package com.seakie;

import java.util.ArrayList;
import java.util.Scanner;

public class C2014 {
	private static Scanner scan = new Scanner(System.in);
	
	public static void q4Party() {
		int all = 10;
		int[] a = {2, 3};
		ArrayList<Integer> people = new ArrayList<Integer>();
		for (int i = 1; i <= all; i ++) {
			people.add(i);
		}
//		System.out.println(people);

		
		for (int i = 0; i < a.length; i ++) {
			for (int j = a[i] - 1; j < people.size(); j += a[i]) {
				people.set(j, 0);
			}
			System.out.println(people);
			for (int j = 0; j < people.size(); j ++) {
				if (people.get(j) == 0) {
					people.remove(j);
				}
			}
			System.out.println(people);
		}
		System.out.println(people);
	}

	public static void q1Triangle() {
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		if (a + b + c != 180)
			System.out.println("Error");
		else if (a == 60 && b == 60)
			System.out.println("Equilateral");
		else if (a == b || b == c || a == c)
			System.out.println("Isosceles");
		else if (a != b && b != c && c != a)
			System.out.println("Scalene.");
	}

	public static void q2Vote() {
		int all = scan.nextInt();
		scan.nextLine();
		String vote = scan.nextLine();
		int ticketA = 0;
		int ticketB = 0;
		for (int index = 0; index < all; index ++){
			if (vote.charAt(index) == 'A'){
				ticketA ++;
			} else if (vote.charAt(index) == 'B'){
				ticketB ++;
			}
		}
		
		if (ticketA > ticketB) {
			System.out.println("A");
		} else if (ticketA < ticketB) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}
}
