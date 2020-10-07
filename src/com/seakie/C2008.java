package com.seakie;

import java.util.HashMap;
import java.util.Scanner;

public class C2008 {

	public static void q3GPS() {
		char[][] keyboard = {
				{'A', 'B', 'C', 'D', 'E', 'F'},
				{'G', 'H', 'I', 'J', 'K', 'L'},
				{'M', 'N', 'O', 'P', 'Q', 'R'},
				{'S', 'T', 'U', 'V', 'W', 'X'},
				{'Y', 'Z', ' ', '-', '.', '+'}
		};
		
		HashMap<Character, Point> alphabet = new HashMap<Character, Point>();
		int x = 0;
		int y = 0;
		for (int ch = 'A'; ch <= 'Z'; ch++){
			alphabet.put(new Character((char) ch), new Point(x, y++));
			if (y % 6 == 0){
				y = 0;
				x ++;
			}
		}

		alphabet.put(' ', new Point(x, y++));
		alphabet.put('-', new Point(x, y++));
		alphabet.put('.', new Point(x, y++));
		alphabet.put('+', new Point(x, y++));
		
//		for (Character key : alphabet.keySet()){
//			System.out.println("" + key + alphabet.get(key).X + " " + alphabet.get(key).Y);
//		}

		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine() + '+';
		sc.close();
		
//		System.out.println(msg);
		char prev = 'A';
		
		int sum = 0;
		for (int index = 0; index < msg.length(); index++){
			char ch = msg.charAt(index);
//			System.out.println(ch);
			// we need previous and current char
//			int steps = getSteps(ch, prev, keyboard);
			Point cur = alphabet.get(ch);
			int steps = Math.abs(alphabet.get(ch).X - alphabet.get(prev).X) 
					+ Math.abs(alphabet.get(ch).Y - alphabet.get(prev).Y);
			sum += steps;
			prev = ch;
		}
		
		System.out.println(sum);
	}

	private static int getSteps(char current, char prev, char[][] keyboard) {
		int chX = 0;
		int chY = 0;
		for (int x = 0; x < 5; x++){
			for (int y = 0; y < 6; y++){
				if (keyboard[x][y] == current){
					chX = x;
					chY = y;
				}
			}
		}
		int preX = 0;
		int preY = 0;
		for (int x = 0; x < 5; x++){
			for (int y = 0; y < 6; y++){
				if (keyboard[x][y] == prev){
					preX = x;
					preY = y;
				}
			}
		}
		
		int result = Math.abs(chX - preX) + Math.abs(chY - preY);
		return result;
	}

}
