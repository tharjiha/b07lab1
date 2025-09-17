public class Polynomial {
	double[] coefficients;

	public Polynomial(double[] c) {
		coefficients = c;
	}

	public Polynomial() {
		double[] array = { 0 };
		coefficients = array;
	}

	public Polynomial add(Polynomial x) {
		int length = coefficients.length;
		if (x.coefficients.length > coefficients.length) {
			length = x.coefficients.length;
		}

		double[] array = new double[length];
		for (int i = 0; i < length; i++) {
			array[i] = 0;
			if (i < x.coefficients.length) {
				array[i] += x.coefficients[i];
			}
			if (i < coefficients.length) {
				array[i] += coefficients[i];
			}
		}

		Polynomial sum = new Polynomial(array);
		return sum;
	}

	private double pow(double x, int i) {
		double result = 1;
		for (int j = 0; j < i; j++) {
			result *= x;
		}
		return result;
	}

	public double evaluate(double x) {
		double value = 0;
		for (int i = 0; i < coefficients.length; i++) {
			value += coefficients[i] * pow(x, i);
		}
		return value;
	}

	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
}