package com.seakie;

import java.util.Scanner;

public class ACM {

	// http://acm.hdu.edu.cn/showproblem.php?pid=2084
	/*
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5
	 */
	public static void numberTower() {
		Scanner scan = new Scanner(System.in);
		int five = scan.nextInt();
		int matrix[][] = new int[five][five];
		for (int x = 0; x < five; x++){
			for (int y = 0; y < x + 1; y++){
				matrix[x][y] = scan.nextInt();
			}
		}
		scan.close();
		
		for (int x = five - 2; x >= 0; x--){
			for (int y = 0; y < x + 1; y++){
				int sum1 = matrix[x][y] + matrix[x + 1][y];
				int sum2 = matrix[x][y] + matrix[x + 1][y + 1];
				matrix[x][y] = Math.max(sum1, sum2);
			}
		}
		System.out.println(matrix[0][0]);
	}

}
