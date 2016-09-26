package task04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import task06.Matrix;

public class App04Test {

	@Test
	public void testOneGenerateMatrix() throws Exception {
		int[] A = {};
		int maxElementInList = 50;
		int[] expected = {};

		int[] m = App04.fillArray(A.length, maxElementInList);

		for (int i = 0; i < m.length; i++) {
			assertEquals(expected[i], m[i]);
		}
	}

}
