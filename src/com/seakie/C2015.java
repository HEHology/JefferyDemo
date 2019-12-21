package com.seakie;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class C2015 {
	static int pies = 8;
	static int people = 4;
	static Scanner scan = new Scanner(System.in);
	
	public static void q1SpecialDay() {
		int mon = scan.nextInt();
		int day = scan.nextInt();
		
		int all = mon * 100 + day;
		if (all < 218)
			System.out.println("Before");
		else if (all == 218)
			System.out.println("Special");
		else
			System.out.println("After");
	}

	public static void q2HappySad() {
		String line = scan.nextLine();
		String[] parts = (line + " ").split(":-\\(");
		System.out.println(parts.length);
		for (String p : parts){
			System.out.println(p);
		}
	}

	public static void q5PieDay() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int pos = 0;
		ArrayList<Integer> init = new ArrayList<Integer>();
		int all = people;
		while ((all--) != 0) init.add(0);
		result.add(init);

		while (pos != result.size()) {
			ArrayList<Integer> current = result.get(pos);
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			getNewOnes(current, temp);
			result.addAll(temp);
			pos ++;
		}
		
		Set<ArrayList<Integer>> setResult = new LinkedHashSet< ArrayList<Integer> > (result);
		System.out.println(setResult);
		for (ArrayList<Integer> unit : setResult) {
			if (notEmpty(unit) && sumAll(unit) == pies) {
				System.out.println(unit);
			}
		}
	}

	private static boolean notEmpty(ArrayList<Integer> unit) {
		for (Integer item : unit) {
			if (item == 0) {
				return false;
			}
		}
		return true;
	}

	private static void getNewOnes(ArrayList<Integer> current, ArrayList<ArrayList<Integer>> temp) {
		ArrayList<Integer> newOne = new ArrayList<Integer>(current);
		Integer newLast = newOne.get(newOne.size() - 1);
		if (sumAll(newOne) < pies) {
			newOne.set(newOne.size() - 1, newLast + 1);
			temp.add(newOne);
		}

		for (int i = current.size() - 2; i >= 0; i--) {
			ArrayList<Integer> newOne1 = new ArrayList<Integer>(current);
			Integer newPie = newOne1.get(i) + 1;
			if (newPie <= newOne1.get(i + 1)
					&& sumAll(newOne1) < pies) {
				newOne1.set(i, newPie);
				temp.add(newOne1);
			}
		}
	}

	private static int sumAll(ArrayList<Integer> newOne1) {
		int sum = 0;
		for (Integer unit : newOne1) {
			sum += unit;
		}
		return sum;
	}

	public static void q3Rovarspraket() {
		String line = scan.nextLine();
		int state = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			state = getState(ch);
			
			switch (state) {
			case 0: // vowel
				sb.append(ch);
				break;
			case 1:
				sb.append(ch);
				sb.append(closeVowel(ch));
				sb.append(next(ch));
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

	private static char next(char ch) {
		String vls = "aeiou";
		if (ch == 'z')
			return ch;
		if (vls.indexOf(ch + 1) == -1)
			return (char) (ch + 1);
		else
			return (char) (ch + 2);
	}

	private static char closeVowel(char ch) {
		String vls = "aeiou";
		
		int record = 100;
		char result = 'a';
		
		for (int i = 0; i < vls.length(); i++){
			int dist = Math.abs(vls.charAt(i) - ch);
			if (record > dist){
				record = dist;
				result = vls.charAt(i);
			}
		}
		
		return result;
	}

	private static int getState(char ch) {
		String vls = "aeiou";
		if (vls.indexOf(ch) != -1){ // vowel
			return 0;
		}
		return 1;
	}

	/*
5
R 2
R 3
W 5
S 2
S 3
	 */
	public static void q4WaitTime() {
		int all = scan.nextInt();
		scan.nextLine();
		ArrayList<Integer> record = new ArrayList<Integer>();
		
		for (int i = 0; i < all; i++){
			String line = scan.nextLine();
			String[] parts = line.split(" ");
			int data = Integer.parseInt(parts[1]);
			
			switch(parts[0]){
			case "S":
			case "R":
				record.add(data);
				break;
			case "W":
				for (int j = 1; j < data; j++){
					record.add(-1);
				}
				break;
			}
		}
		
		System.out.println(record);
		
//		LinkedHashMap<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
//		for (int i = 0; i < record.size(); i++){
//			int code = record.get(i);
//			if (result.get(code) == null && code != -1){
//				result.put(code, 0);
//			}
//			for (int key : result.keySet()){
//				if (result.get(key) % 2 == 1){
//					result.put(key, result.get(key) + 1);
//				}
//			}
////			result.put(code, )
//		}
		
//		System.out.println(result);
	}



	
}
