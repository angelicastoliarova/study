package task06;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {
	
	@Test
	public void matrixIsSquare() {
		int[] A = {1, 2, 3};
		int[][]m = Matrix.generateMatrix(A.length, A);
		
		for (int i = 0; i < m.length; i++) {
			assertEquals(m.length, m[i].length);
		}
	}

	@Test
	public void testOneGenerateMatrix() {
		int[] A = {1, 2, 3};
		int[][] expected = { {1, 2, 3}, {2, 3, 1}, {3, 1, 2} };
		
		int[][]m = Matrix.generateMatrix(A.length, A);
		
		for (int i = 0; i < m.length; i++) {
			assertArrayEquals(expected[i], m[i]);
		}
	}
	
	@Test
	public void testTwoGenerateMatrix() {
		int[] A = {2, 1, 10, 4, 5};
		int[][] expected = {
			{2, 1, 10, 4, 5}, 
			{1, 10, 4, 5, 2}, 
			{10, 4, 5, 2, 1}, 
			{4, 5, 2, 1, 10}, 
			{5, 2, 1, 10, 4}
		};
		
		int[][]m = Matrix.generateMatrix(A.length, A);
		
		for (int i = 0; i < m.length; i++) {
			assertArrayEquals(expected[i], m[i]);
		}
	}
}
