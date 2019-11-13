package com.seakie;

import java.util.Scanner;

public class C2012 {

	public static void q4BigBang() {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder(str);
		for (int p = 0; p < sb.length(); p++) {
			char ch = sb.charAt(p);
			int shift = 3 * (p + 1) + K;
//			System.out.println(shift + " for " + ch);
			if (ch - shift < 'A')
			{
				ch += 26;
			}
			ch = (char) (ch - shift);
			sb.setCharAt(p, ch);
		}
		
		System.out.println(sb);
		sc.close();
	}

}
