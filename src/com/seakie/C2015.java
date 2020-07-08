package com.seakie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class Sms {
	public char action;
	public int person;
	@Override
	public String toString() {
		return "" + action + "-" + person ;
	}
	
}

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
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt(); // for length of timeline
		scan.nextLine();
		Sms[] timeline = new Sms[count * 2];
		int currentTime = 0;
		
		for (int index = 0; index < count; index++){
			// S 2 or R 3
			String message = scan.nextLine();
			String[] segments = message.split(" ");
			
			String state = segments[0];
			
			switch (state) {
			case "R":
			case "S":
				// Receive
				// send
				record(segments, currentTime, timeline);
				currentTime ++;
				break;
			case "W":
				// wait
				currentTime += wait(segments);
				break;
			default:
				break;
			}
//			System.out.println(message);
		}
		
		System.out.println(Arrays.toString(timeline));
		printResult(timeline);
		scan.close();
	}

	private static void printResult(Sms[] timeline) {
		int[] recording = new int[1000];
		
		for (int start = 0; start < timeline.length; start++){
			Sms currentUnit = timeline[start];
			if (currentUnit == null)
				continue;
			int endPos = - 1; // Assume I cannot find ending
			if (currentUnit.action == 'R'){
				for (int end = start + 1; end < timeline.length; end++){
					Sms endUnit = timeline[end];
					if (endUnit == null)
						continue;
					if (endUnit.action == 'S' && endUnit.person == currentUnit.person){
						endPos = end;
						break;
					}
				}
				if (endPos != -1) {
					recording[currentUnit.person] += endPos - start;
				} else {
					recording[currentUnit.person] = -1;
				}
			}
		}
		
		for (int index = 0; index < recording.length; index++){
			if (recording[index] != 0) {
				System.out.println(index + " " + recording[index]);
			}
		}
	}

	private static int wait(String[] segments) {
		return Integer.parseInt(segments[1]) - 1;
	}

	private static void record(String[] segments, int currentTime, Sms[] timeline ) {
		Sms unit = new Sms();
		unit.action = segments[0].charAt(0);
		unit.person = Integer.parseInt(segments[1]);
		
		timeline[currentTime] = unit;
	}


	
}
