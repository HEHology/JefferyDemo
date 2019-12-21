package com.seakie;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C2016 {
	private static Scanner scan = new Scanner(System.in);
	
	public static void q1() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		result.put("W", 0);
		result.put("L", 0);
		for (int i = 0; i < 6; i ++) {
			String ch = sc.nextLine();
			result.put(ch, result.get(ch) + 1);
		}
//		System.out.println(result.get("W"));
		switch (result.get("W")) {
		case 5:
		case 6:
			System.out.println(1);
			break;
		case 3:
		case 4:
			System.out.println(2);
			break;
		case 1:
		case 2:
			System.out.println(3);
			break;
		default:
			System.out.println(-1);
			break;
		}
		sc.close();
	}

	public static void q4ArralTime() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] time = input.split(":");
		
		int hour = Integer.valueOf(time[0]);
		int min = Integer.valueOf(time[1]);
		
		int now = hour * 60 + min;

		int speed = 2;
		int dist = speed * 2 * 60;
		
		while (dist > 0) {
			if (isRushHour(now)) {
				speed = 1;
			} else {
				speed = 2;
			}
			
			dist -= speed;
			now ++;
		}
		
//		now --;

		System.out.println(
			String.format("%02d:%02d", (now / 60) % 24, now % 60)
				);
		
		scan.close();
	}

	private static boolean isRushHour(int nowMin) {
		if (7 * 60 <= nowMin && nowMin < 10 * 60)
			return true;
		if (15 * 60 <= nowMin && nowMin < 19 * 60)
			return true;
		
		return false;
	}

	
	/*
16 3 2 13
5 10 11 8
9 6 7 12
4 15 14 1
	 */
	public static void q2MagicSquire() {
		int[][] square = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				square[i][j] = scan.nextInt();
			}
		}
		
		int sum = square[0][0] + square[0][1] 
				+ square[0][2] + square[0][3];
		
		for (int i = 0; i < 4; i++) {
			int adding = 0;
			for (int j = 0; j < 4; j++) {
				adding += square[i][j];
			}
			
			if (adding != sum) {
				System.out.println("not magic");
				return;
			}
		} 

		for (int i = 0; i < 4; i++) {
			int adding = 0;
			for (int j = 0; j < 4; j++) {
				adding += square[j][i];
			}
			
			if (adding != sum) {
				System.out.println("not magic");
				return;
			}
		}
		
		System.out.println("magic");
	}

	// banana
	public static void q3LongPalindrome() {
		String line = scan.nextLine();
		int record = 0;
		for (int i = 0; i < line.length(); i++){
			for (int j = i + 1; j <= line.length(); j++){
				String sub = line.substring(i, j);
//				System.out.println(sub);
				String rev = new StringBuilder(sub).reverse().toString();
				if (rev.equals(sub)) {
					int newLength = rev.length();
					if (newLength > record){
						record = newLength;
					}
				}
			}
		}
		
		System.out.println(record);
	}


	public static void q5TandemBicycle() {
		int way = scan.nextInt();
		int count = scan.nextInt();
		int[][] players = new int[2][count];
				
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < count; j++) {
				players[i][j] = scan.nextInt();
//				System.out.print(players[i][j]);
			}
		}
		
		Arrays.sort(players[0]);
		Arrays.sort(players[1]);
		
		int result = 0;
		if (way == 1){
			for (int i = 0; i < count; i++){
				result += Math.max(players[0][i], players[1][i]); 
			}
		} else if (way == 2){
			Integer[] all = new Integer[count * 2];
			for (int i = 0; i < count; i++){
				all[i] = players[0][i];
				all[count + i] = players[1][i];
			}
			Arrays.sort(all, Collections.reverseOrder());
			
			for (int i = 0; i < count; i++){
//				System.out.println(all[i]);
				result += all[i];
			}
		}
		
		System.out.println(result);
	}

}
