package task1;

import java.math.*;

public class Calculate {
	double x;
	double y;
	double res;

	public Calculate(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public double result() {
		res = (1 + Math.sqrt(1 + Math.sqrt(Math.sin(x + y))))
				/ (2 + Math.abs(x - (2 * x / 1 + Math.sqrt(x) * Math.sqrt(y))));
		return res;

	}

}
