package task05;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubsequenceTest {

	@Test
	public void testFindMinK() {
		int[] arr = { 1, 2, -1, 3, 0, 4, 5};
		
		int expected = 2;
		int result = Subsequence.findMinK(arr);

		assertEquals(expected, result);
	}

	@Test
	public void testFindLengthOfMaxSubsequence() {
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		int expected = 6;
		int result = Subsequence.findLengthOfMaxSubsequence(arr);
		
		assertEquals(expected, result);
	}

	@Test
	public void testIncreasingSubsequence() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7};
		
		int expected = 0;
		int result = Subsequence.findMinK(arr);

		assertEquals(expected, result);
	}
	
	@Test
	public void testDecreasingSubsequence() {
		int[] arr = { 7, 6, 5, 4, 3, 2, 1};
		
		int expected = 6;
		int result = Subsequence.findMinK(arr);

		assertEquals(expected, result);
	}
}
