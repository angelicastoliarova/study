package task1;

public class Formula {

	public static void main(String[] args) {
		double x = 5;
		double y = 1;
		Calculate ob = new Calculate(x, y);
		System.out.println(ob.result());
	}

}
