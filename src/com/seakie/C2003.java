package com.seakie;

import java.util.Scanner;

public class C2003 {

	public static void q3Dice() {
		Scanner sc = new Scanner(System.in);
		int position = 1;
		int dice = 0;
		
		int[] rules = new int[100];
		rules[9] = 34;
		rules[40] = 64;
		rules[67] = 86;
		rules[54] = 19;
		rules[90] = 48;
		rules[99] = 77;
		
		while(true){
			if (position == 100){
				break;
			}
			System.out.println("Enter sum of dice:");
			dice = sc.nextInt();
			position += dice;
			
			if (position > 100){
				position -= dice;
			}
			
			// game rules, now
			if (rules[position] != 0){
				position = rules[position];
			}

			if (dice == 0){
				System.out.println("You Quit!");
				return;
			}
			
			System.out.println("You are now on square " + position);
		}
		
		System.out.println("You Win");
	}

}
