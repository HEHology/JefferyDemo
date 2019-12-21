package com.seakie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/*
4
+++===!!!!
777777......TTTTTTTTTTT
(AABBC)
3.1415555
*/

public class C2019 {
	public static void q3ColdComp() {
		Scanner sc = new Scanner(System.in);
		// how many lines?
		int lines = sc.nextInt();
		sc.nextLine();
		// loop all the lines
		for (int line = 0; line < lines; line ++) {
		// get every string in the lines
			String str = sc.nextLine();
		// and use the string
			goThroughLine(str);
		}
		sc.close();
	}

	public static void goThroughLine(String str) {
		ArrayList<CharIntPair> chain = new ArrayList<CharIntPair>();
		// every line need at least one pair
		CharIntPair curPair = new CharIntPair();
		chain.add(curPair);
		
		for (int index = 0; index < str.length(); index ++) {
			// take advantage of every char
			char ch = str.charAt(index);
			// check the counting char
			if (curPair.ch != ch && curPair.count != 0){
			// if is not, create a new current pair
				curPair = new CharIntPair();
				chain.add(curPair);
			}
			curPair.ch = ch;
			curPair.count ++;
		}

		for (CharIntPair unit : chain) {
			System.out.print(unit.count + " " + unit.ch + " ");
		}
		System.out.println();
	}

	
/*
4
+++===!!!!
777777......TTTTTTTTTTTT
(AABBC)
3.1415555	
 */

	public static void q3ColdCompEx() {
		ArrayList<String> record = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < count; i ++) {
			record.add(sc.nextLine());
		}
		
		sc.close();
//		System.out.println(record);
		
		for (int i = 0; i < count; i++) {
			String line = record.get(i);
//			System.out.println(line);
			parseLine(line);
		}
	}

	private static void parseLine(String line) {
		char old = 0;
		int state = 0;
		HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
		for (int i = 0; i < line.length(); i++){
			char ch = line.charAt(i);
			
			if (old == ch) {
				state = 1; // continue;
			} else if (old == 0) {
				state = 2; // start;
			} else if (old != ch) {
				state = 3;	// new comer
			}
			old = ch;
			
//			System.out.println(state);
			switch (state){
			case 1:
				mp.put(ch, mp.get(ch) + 1);
				break;
			case 2:
				mp.put(ch, 1);
				break;
			case 3:
				System.out.print(mp);
				mp.clear();
				mp.put(ch, 1);
				break;
			}
		}
		System.out.println(mp);
	}

	public static void q4Flipper() {
		Scanner sc = new Scanner(System.in);
		int[][] arr = {{1, 2}, 
				{3, 4}};
		
		String line = sc.nextLine();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == 'V')
				vOnArr(arr);
			else if (ch == 'H')
				hOnArr(arr);
		}
		printArr(arr);
		sc.close();
	}

	private static void vOnArr(int[][] arr) {
		int temp = 0;
		temp = arr[0][0];
		arr[0][0] = arr[1][0];
		arr[1][0] = temp;
		temp = arr[0][1];
		arr[0][1] = arr[1][1];
		arr[1][1] = temp;
	}

	private static void hOnArr(int[][] arr) {
		int temp = 0;
		temp = arr[0][0];
		arr[0][0] = arr[0][1];
		arr[0][1] = temp;
		temp = arr[1][0];
		arr[1][0] = arr[1][1];
		arr[1][1] = temp;
	}

	private static void printArr(int[][] arr) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0 ; j < 2; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void q5RuleOfThree() {
		LinkedHashMap<String, String> rules = new LinkedHashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String[] info = sc.nextLine().split(" ");
			rules.put(info[0], info[1]);
		}
		
		String line = sc.nextLine();
		
		String[] starter = line.split(" ");
		
		System.out.println(rules);
		System.out.println(starter.length);
		
		sc.close();
	}

}
