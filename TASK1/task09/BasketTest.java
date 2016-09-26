package task09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BasketTest {

	@Test
	public void testAddBall() {
		Basket basket = new Basket();
		
		Ball ball = new Ball("green", 2);
		basket.addBall(ball);
		
		assertEquals(1, basket.getItems().size());
		assertTrue(basket.getItems().get(0).equals(ball));
	}
	
	@Test
	public void testAddItems() {
		Basket basket = new Basket();
		Ball[] balls = { new Ball("green", 1), new Ball("red", 2), new Ball("blue", 1.5) };
		
		for (int i = 0; i < balls.length; i++) {
			basket.addBall(balls[i]);
		}
		
		assertEquals(balls.length, basket.getItems().size());
		
		List<Ball> items = basket.getItems();
		for (int i = 0; i < balls.length; i++) {
			assertEquals(balls[i], items.get(i));
		}
	}
	
	@Test
	public void countBlueBalls() {
		Basket basket = new Basket();
		Ball[] balls = { 
				new Ball("green", 1), new Ball("blue", 0.5) , 
				new Ball("red", 2), new Ball("blue", 1.5), 
				new Ball("blue", 4), new Ball("yellow", 2) };
		
		for (int i = 0; i < balls.length; i++) {
			basket.addBall(balls[i]);
		}
		
		assertEquals(3, basket.getBallsNumber("blue"));
	}
	
	@Test
	public void countBasketWeight() {
		Basket basket = new Basket();
		Ball[] balls = { 
				new Ball("green", 1), new Ball("blue", 0.5) , 
				new Ball("red", 2), new Ball("blue", 1.5), 
				new Ball("blue", 4), new Ball("yellow", 2) };
		
		for (int i = 0; i < balls.length; i++) {
			basket.addBall(balls[i]);
		}
		
		assertEquals(11, basket.getBusketWeight(), 0.01);
	}

}
