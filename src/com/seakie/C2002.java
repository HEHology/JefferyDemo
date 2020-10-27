package com.seakie;

import java.util.Scanner;

public class C2002 {

	public static void q3Tickets() {
		Scanner sc = new Scanner(System.in);
		int pink = sc.nextInt();
		int green = sc.nextInt();
		int red = sc.nextInt();
		int orange = sc.nextInt();
		int amount = sc.nextInt();
		
		sc.close();
		int record = Integer.MAX_VALUE;
		int combin = 0;
		
		for (int p = 0; p <= amount; p++){
			for (int g = 0; g <= amount; g++){
				for (int r = 0; r <= amount; r++){
					for (int o = 0; o <= amount; o++){
						if (p * pink + g * green + r * red + o * orange == amount){
							System.out.println(p + " " + g + " " + r + " " + o );
							combin ++;
							if (p + g + r + o < record){
								record = p + g + r + o;
							}
						}
					}
				}
			}
		}
		System.out.println("Total combinations is " + combin);
		System.out.println("Minimum number of tickets to print is " + record);
	}

}
