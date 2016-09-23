/**
 * 
 */
package task1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class tst1 {
	private double expected;
	private double result;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Calculate ob = new Calculate(5, 4);
		expected = 0.19886372122160265;
		ob.result();
		assertEquals(expected, ob.result(), 0.0);
	}

}
