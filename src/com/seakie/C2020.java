package com.seakie;

import java.util.ArrayList;

class Node {
	@Override
	public String toString() {
		return "(" + x + " " + y + " " + value + ")";
	}
	public Node(int i, int j, int k) {
		x = i; y = j; value = k;
	}
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
		tree.add(new Node(0, 0, 3));
		
		int index = 0;
		while(index < tree.size()) {
			Node current = tree.get(index);
			ArrayList<Node> localList = getSubNodes(current, matrix);
			
			for (Node node : localList) {
				if (isInside(node, tree) == false){
					tree.add(node);
				}
			}
			
			System.out.println(tree);
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
		
		for (int a = 0; a <= current.value; a++){
			for (int b = 0; b <= current.value; b ++) {
				if (a * b == current.value) {
					if (a <= row && b <= col) {
						local.add(new Node(a - 1, b - 1, matrix[a - 1][b - 1]));
					}
				}
			}
		}
		
		return local;
	}

}
