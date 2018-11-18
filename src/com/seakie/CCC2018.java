package com.seakie;

import java.util.Scanner;

public class CCC2018 {
	public void question1() {
		Scanner scan = new Scanner(System.in);
		
		int one = scan.nextInt();
		int two = scan.nextInt();
		int three = scan.nextInt();
		int four = scan.nextInt();
		
		// every combined condition for one line and one bracket
		if ( ((one == 8) || (one == 9))  // the first of these four digits is an 8 or 9;
			&& ((four == 8) || (one == 9)) // the last digit is an 8 or 9;
			&& (two == three) // the second and third digits are the same
			)  {
			System.out.println("Ignore");
		} else {
			System.out.println("Answer");
		}
	}
}
