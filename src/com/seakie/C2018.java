package com.seakie;

import java.util.ArrayList;
import java.util.Scanner;

public class C2018 {
	private static Scanner scan = new Scanner(System.in);

	public static void q1Tele() {
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			inputs.add(scan.nextInt());
		}

		if ((inputs.get(0) == 8 || inputs.get(0) == 9) || (inputs.get(3) == 8 || inputs.get(3) == 9)
				|| (inputs.get(1) == inputs.get(2))) {
			System.out.println("ignore");
		} else {
			System.out.println("answer");
		}
	}

	/*
7 
CCCCCCC
C.C.C.C
	 */
	public static void q2OccupyParking() {
		String parking1;
		String parking2;

		int count = scan.nextInt();
		scan.nextLine();
		parking1 = scan.nextLine();
		parking2 = scan.nextLine();

		int avai = 0;

		for (int i = 0; i < count; i++) {
			if (parking1.charAt(i) == 'C' && parking2.charAt(i) == 'C') {
				avai++;
			}
		}

		System.out.println(avai);
	}

	public static void q3AreWeThere() {
		String[] info = scan.nextLine().split(" ");
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			lst.add(Integer.parseInt(info[i]));
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(getDist(lst, Math.min(i, j), Math.max(i, j)) + " ");
			}
			System.out.println();
		}
	}

	// 3 10 12 5
	private static int getDist(ArrayList<Integer> lst, int i, int j) {
		int result = 0;
		for (int index = i; index < j; index++) {
			result += lst.get(index);
		}
		return result;
	}

	/*
3
3 7 9 
2 5 6 
1 3 4
	 */
	public static void q4Sunflower() {
		int side = scan.nextInt();
		scan.nextLine();
		int[][] flower = new int[side][side];

		for (int i = 0; i < side; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < side; j++) {
				flower[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}

		for (int i = 0; i < 4; i++){
			if (isQualified(flower) == false) {
				roll(flower);
			}
		}
		output(flower);
//		System.out.println(flower);
	}

	private static void roll(int[][] flower) {
		int side = flower.length;
		int[][] temp = new int[side][side];
		
		for (int i = 0; i < side; i ++)
			temp[i] = flower[i].clone();

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j ++) {
				flower[i][j] = temp[j][side - i - 1];
//				System.out.println(temp[j][side - i - 1] + " -> " + i + ":" + j);
			}
		}
	}

	private static boolean isQualified(int[][] flower) {
		int side = flower.length;
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (flower[i][j] > flower[Math.min(i + 1, side - 1)][j])
					return false;
				if (flower[i][j] > flower[i][Math.min(j + 1, side - 1)])
					return false;
			}
		}
		return true;
	}

	private static void output(int[][] flower) {
		for (int i = 0; i < flower.length; i++) {
			for (int j = 0; j < flower.length; j++) {
				System.out.print(flower[i][j] + " ");
			}
			System.out.println();
		}
	}

}
