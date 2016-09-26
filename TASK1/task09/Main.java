package task09;

import java.util.Random;

public class Main {
	
	public static String[] colors = {"black", "red", "blue", "green", "yellow"};

	public static void main(String[] args) {
		Random r = new Random();
		Basket basket = new Basket();
		
		for (int i = 0; i < 100; i++) {
			String color = colors[r.nextInt(colors.length)];
			double weight = 0.5 + r.nextDouble();
			Ball ball = new Ball(color, weight);
			
			basket.addBall(ball);
		}
		
		System.out.format("Basket Weight =  %.2f\n", basket.getBusketWeight());
		System.out.println("Number of the blue balls = " + basket.getBallsNumber("blue"));
	}

}
