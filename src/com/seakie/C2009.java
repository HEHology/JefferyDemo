package com.seakie;

import java.util.Scanner;

public class C2009 {

	public static void q1ISBN() {
		int base = 9 * 1 + 7 * 3 + 8 * 1 + 0 * 3 + 9 * 1 + 2 * 3 + 1 * 1 + 4 * 3 + 1 * 1 + 8 * 3 ;
		Scanner scan = new Scanner(System.in);
		int[] num = new int[3];
		for (int i = 0; i < 3; i++){
			num[i] = scan.nextInt();
		}
		
		for (int i = 0; i < 3; i++){
			if (i % 2 == 0){
				base += num[i] * 1;
			} else {
				base += num[i] * 3;
			}
		}
		
		System.out.printf("The 1-3-sum is %d", base);
		scan.close();
	}

	public static void q2FishingHole() {
		Scanner scan = new Scanner(System.in);
		int trout = scan.nextInt();
		int pike = scan.nextInt();
		int pickerel = scan.nextInt();
		int allowed = scan.nextInt();
		int count = 0;
		
		for (int pickerelCount = 0; pickerelCount <= allowed; pickerelCount ++){
			for (int pikeCount = 0; pikeCount <= allowed; pikeCount ++){
				for (int trountCount = 0; trountCount <= allowed; trountCount ++){
					if ((trountCount + pikeCount + pickerelCount > 0)
							&& (trout * trountCount + pike * pikeCount + pickerel * pickerelCount <= allowed)) {
						System.out.printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n",
								trountCount, pikeCount, pickerelCount);
						count ++;
					}
				}
			}
		}
		
		System.out.printf("Number of ways to catch fish: %d\n", count);
		scan.close();
	}

}
