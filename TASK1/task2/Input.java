package task2;

import java.io.IOException;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) throws IOException {

		double x = 0;
		double y = 0;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Input x");
			x = sc.nextDouble();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Input y");
			y = sc.nextDouble();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (((x < 4) && (x > -4)) && ((y > -3.2) && (y < 5)))

		{
			System.out.println("result isTrue");
		} else if ((((x < 6) && (x > -6)) || ((x < -4) && (x > 4))) && ((y < 0) && (y < 3.2))) {
			System.out.println("result is True");
		} else {
			System.out.println("result is False");
		}

	}

}
