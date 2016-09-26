package task06;

import java.util.Scanner;

public class Matrix {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n;
		int[] A;

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		
		int[][] m = generateMatrix(n, A);
		
		printMatrix(m);
	}
	
	public static int[][] generateMatrix(int n, int[] A) {
		int[][] m = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = A[(i + j) % n];
			}
		}
		
		return m;
	}
	
	public static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
