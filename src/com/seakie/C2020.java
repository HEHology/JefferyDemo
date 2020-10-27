package com.seakie;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	public int x;
	public int y;
	public int value;
}
public class C2020 {

	static int row = 3;
	static int col = 4;
	public static void q5QuitRoom() {
		int matrix[][] = { 
				{3, 10, 8, 14},
				{1, 11, 12, 12},
				{6, 2, 3, 9}
				};
		
		ArrayList<Node> tree = new ArrayList<Node>();
		Node root = new Node();
		root.x = 0;
		root.y = 0;
		root.value = 3;
		tree.add(root);
		
		int index = 0;
		while(index < tree.size()) {
			Node current = tree.get(index);
			ArrayList<Node> localList = getSubNodes(current, matrix);
			
			for (Node node : localList) {
				if (isInside(node, tree) == false){
					tree.add(node);
				}
			}
			
//			System.out.println(tree);
			if (isEnded(tree) == true) {
				System.out.println("yes");
				return;
			}
			index ++;
		}
		
		System.out.println("no");
	}

	private static boolean isEnded(ArrayList<Node> result) {
		for (Node node : result) {
			if (node.x == row - 1 && node.y == col - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean isInside(Node node, ArrayList<Node> result) {
		for (Node nodeInResult : result) {
			if (nodeInResult.x == node.x && nodeInResult.y == node.y) {
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Node> getSubNodes(Node current, int[][] matrix) {
		ArrayList<Node> local = new ArrayList<Node>();
		
		for (int xPosition = 0; xPosition <= current.value; xPosition++){
			for (int yPosition = 0; yPosition <= current.value; yPosition ++) {
				if (xPosition * yPosition == current.value) {
					if (xPosition <= row && yPosition <= col) {
						Node sub = new Node();
						sub.x = xPosition - 1;
						sub.y = yPosition - 1;
						sub.value = matrix[xPosition - 1][yPosition - 1];
						local.add(sub);
					}
				}
			}
		}
		
		return local;
	}

	/*
ABCCDEABAA
ABCDE
	 */
	public static void q4Shift() {
		Scanner scan = new Scanner(System.in);
		String base = scan.nextLine();
		String key = scan.nextLine();
		scan.close();
		
		int len = key.length();
		for (int index = 0; index < base.length() - len; index++){
			String sub = base.substring(index, index + len);
//			System.out.println(sub);
			if (isShifts(sub, key)){
				System.out.println("yes");
				return;
			}
		}
		System.out.println("no");
//		for (int start = 0; start < base.length(); start++){
//			for (int end = start; end <= base.length(); end++){
//				String sub = base.substring(start, end);
//				if (sub.length() == key.length()){
////					System.out.println(sub);
//					if (isShifts(sub, key) == true){
//						System.out.println("yes");
//						return;
//					}
//				}
//			}
//		}
//		System.out.println("no");
	}

	private static boolean isShifts(String sub, String key) {
		for (int times = 0; times < key.length(); times++){
			char ch = key.charAt(0);
			key = key.substring(1, key.length()) + ch;
//			System.out.println(key);
			if (sub.equals(key) == true){
				return true;
			}
		}
		return false;
	}

}
