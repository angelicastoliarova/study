package task09;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	List<Ball> items;
	
	public Basket() {
		items = new ArrayList<Ball>();
	}
	
	public List<Ball> getItems() {
		return items;
	}
	
	public void addBall(Ball ball) {
		items.add(ball);
	}
	
	public double getBusketWeight() {
		double basketWeight = 0;
		for (Ball ball : items) {
			basketWeight += ball.getWeight();
		}
		return basketWeight;
	}
	
	public int getBallsNumber(String color) {
		int num = 0;
		for (Ball ball : items) {
			if (ball.getColor().equals(color)) {
				num += 1;
			}
		}
		return num;
	}
}
