package minskg;

/**
 * @author teamG
 */

public class MathFn {

	/**
	 * to calculate power
	 * 
	 * @param a
	 *            the base
	 * @param b
	 *            the exponent
	 * @return b-th power of a
	 */
	public static double computePower(double a, double b) {
		if (b < 0)
			return 1 / computePower(a, -b);
		else if (b == 0)
			return 1;
		else if (b == 1)
			return a;
		else
			return a * computePower(a, b - 1);
	}

	/**
	 * to calculate square root
	 * 
	 * @param number
	 *            a value
	 * @return the positive square root of the number. If the argument is NaN or
	 *         less than zero, the result is NaN
	 */
	public static double computeSqrt(double number) {
		double first = 0;
		double x;
		double last = 0.0;
		x = number;
		for (;;) {
			first = (x + number / x) / 2.0;
			x = first;
			if (last == first)
				break;
			last = first;
		}
		return first;
	}

	/**
	 * to calculate factorial
	 * 
	 * @param x
	 *            a value
	 * @return factorial of x
	 */
	public static double computeFactorial(int x) {

		double f = (double) x;
		for (int i = x - 1; i > 0; i--) {
			f = f * (double) i;
		}
		return f;
	}

	/**
	 * to calculate cube root with 10 decimal digits result
	 * 
	 * @param x
	 *            a value
	 * @return a cube root of x
	 */
	public static double computeCbrt(double x) {
		return computeCbrt(x, 10);
	}

	/**
	 * to calculate cube root with i-th decimal digits result
	 * 
	 * @param x
	 *            a value
	 * @param digit
	 *            number of digit of cubic function to return
	 * @return a cube root of x
	 */
	public static double computeCbrt(double x, int digit) {
		double y = 0;
		if (x < 0) {
			for (int i = -1; i > x; i--) {
				y = i;
				if (i * i * i < x) {
					y = i + 1;
					break;
				}
			}
		} else {
			for (int i = 0; i < x; i++) {
				if (i * i * i > x) {
					y = i - 1;
					break;
				}
			}
		}
		return computeCbrtDigit(x, y, digit);
	}

	/**
	 * to calculate cube root focus on the number of digits
	 * 
	 * @param x
	 *            a value
	 * @param y
	 *            the integer result
	 * @param digit
	 *            number of digit of cubic function to return
	 * @return a cube root of x
	 */
	private static double computeCbrtDigit(double x, double y, int digit) {
		double value = 0;
		if (x < 0) {
			for (int i = 1; i < digit; i++) {
				for (int j = 1; j < 10; j++) {
					value = (y * MathFn.computePower(10, i) - j) / MathFn.computePower(10, i);
					if (value * value * value < x) {
						y = value + (1 / MathFn.computePower(10, i));
						break;
					}
				}
			}
		} else {
			for (int i = 1; i < digit; i++) {
				for (int j = 1; j < 10; j++) {
					value = (y * MathFn.computePower(10, i) + j) / MathFn.computePower(10, i);
					if (value * value * value > x) {
						y = value - (1 / MathFn.computePower(10, i));
						break;
					}
				}
			}
		}
		return y;
	}
}