package com.seakie;

import java.util.ArrayList;
import java.util.Scanner;

public class C2013 {

	public static void q2Rotating(String inputString) {
		String keys = "IOSHZXN";
		boolean found = false;
		
		for (int i = 0; i < inputString.length(); i++) {
			if (keys.indexOf(inputString.charAt(i)) == -1) {
				found = true;
			}
		}
		if (found) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}
	}

	public static void q5Winning() {
		ArrayList<C2013Q5Match> games = new ArrayList<C2013Q5Match>();
		int score[] = new int[5];
		Scanner sc = new Scanner(System.in);
		int passed = sc.nextInt();
		for (int i = 0; i < passed; i ++) {
			int team1 = sc.nextInt();
			int team2 = sc.nextInt();
			int point1 = sc.nextInt();
			int point2 = sc.nextInt();
			if (team1 > team2) {
				int temp = point1;
				point1 = point2;
				point2 = temp;
				
				temp = team1;
				team1 = team2;
				team2 = temp;
			}
			
			C2013Q5Match game = new C2013Q5Match();
			game.leftTeam = team1;
			game.rightTeam = team2;
			if (point1 > point2) {
				game.result = 1;
				score[team1] += 3;
			} else if (point2 > point1) {
				game.result = -1;
				score[team2] += 3;
			} else {
				game.result = 0;
				score[team1] ++;
				score[team2] ++;
			}
			
			games.add(game);
		}

		for (int i = 0; i < score.length; i++) {
			System.out.println(i + " " + score[i]);
		}
		sc.close();
	}

}
