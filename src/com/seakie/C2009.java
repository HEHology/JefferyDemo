package com.seakie;

import java.util.ArrayList;
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

	public static void q4Signage() {
		String text = "WELCOME TO CCC GOOD LUCK TODAY";
		Scanner scan = new Scanner(System.in);
		int width = scan.nextInt();
		scan.close();
		
		String[] words = text.split(" ");
		int index = 0;
		// row by row
		while (true){
			ArrayList<String> wordsForOutput = new ArrayList<String>();
			int balance = width;
			if (index >= words.length){
				break;
			}
			// pick out first word, and "consume" the width.
			String first = words[index];
			index ++;
			balance -= first.length();
//			System.out.println("begin with " + first);
//			System.out.print(first);
			wordsForOutput.add(first);
			
			// loop the words with space
			while(true){
				// one more break out
				if (index >= words.length){
					break;
				}
				// pre-check word length with space
				if (balance < 1 + words[index].length()){
					break;
				}
				
				String following = words[index];
				index ++;
				balance -= (following.length() + 1);
//				System.out.println("following " + following);
//				System.out.print("." + following);
				wordsForOutput.add(following);
			}
			
			// Welcome.to.CCC, but 3 chars left(balance) to kill?
			// Welcome...to..CCC
			// to assign 3 . to 2 gaps(how do we get gap count? wordsForOutput.size - 1)
			// 3 / 2 = 1 and the remainder put into gaps from first gap
			int gaps = wordsForOutput.size() - 1;
			int mustHave = 0;
			int remainder = 0;
			if (gaps != 0) {
				mustHave = balance / gaps;
				remainder = balance % gaps;
			}
			else {
				mustHave = balance;
				remainder = 0;
			}
			
			
			// output the line (including space inserting)
//			System.out.print(first);
			for (int currentWordIndex = 0; currentWordIndex < wordsForOutput.size(); currentWordIndex++){
				String word = wordsForOutput.get(currentWordIndex);
				// filter out the first word, it does not need a dot-prefix
				if (currentWordIndex != 0)
				{
					System.out.print(".");
				}
				
				System.out.print(word);
//				if (wordsForOutput.size() == 1)
				if ((currentWordIndex != wordsForOutput.size() - 1)
						&& (wordsForOutput.size() != 1))
				{
					for (int dotIndex = 0; dotIndex < mustHave; dotIndex++){
						System.out.print(".");
					}
				} else if (wordsForOutput.size() == 1) {
					for (int dotIndex = 0; dotIndex < mustHave; dotIndex++){
						System.out.print(".");
					}
				}
				if (remainder > 0){
					System.out.print(".");
					remainder --;
				}

			}
			
			System.out.println();
		}
	}

}
