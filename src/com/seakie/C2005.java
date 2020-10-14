package com.seakie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C2005 {

	public static void q3Returing() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> route = new ArrayList<String>();
		route.add("HOME");
		while(true){
			String line = sc.nextLine();
			route.add(line);
			if (line.equals("SCHOOL")){
				break;
			}
		}
		sc.close();
		
		Collections.reverse(route);
//		System.out.println(route.toString());
		for (int index = 1; index < route.size(); index++){
			String line = route.get(index);
			System.out.print("Turn ");
			
			if (line.equals("R")){
				System.out.print("LEFT ");
			} else if (line.equals("L")){
				System.out.print("RIGHT ");
			} 
			
			index ++;
			line = route.get(index);
			if (line.equals("HOME")){
				System.out.print("into your " + line + ".");
			} else {
				System.out.print("onto " + line + " Street.");
			}

			System.out.println();
		}
	}

}
