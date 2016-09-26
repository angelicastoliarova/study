package task03;

import java.util.Scanner;

public class App03 {

	public static void main(String[] args) {
		{
			double a = 0, b = 0, h = 0, result = 0;

			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Input a");
				a = sc.nextDouble();
			} catch (Exception e) {
				System.out.println(e);
			}

			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("Input b");
				b = sc.nextDouble();

			} catch (Exception e) {
				System.out.println(e);
			}

			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("Input h");
				h = sc.nextDouble();

			} catch (Exception e) {
				System.out.println(e);
			}

			
			System.out.println("||  Arg  ||  F(x) || ");
			System.out.println("------------------------------------");
			for (; a <= b; a += h) {
				result = Math.tan(a);

				System.out.println(" || " + a + " || " + result + " || ");
				System.out.println("------------------------------------");
			}

		}
	}
}
