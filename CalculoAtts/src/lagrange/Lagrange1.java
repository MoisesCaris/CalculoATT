package lagrange;

public class Lagrange1 {
	public static void main(String[] args) {
		double[] x = { -2, 0, 2, 3 };
		double[] y = { 5, -2, 3, 6 };
		double targetX = 1;

		double interpolatedY = lagrangeInterpolation(x, y, targetX);
		System.out.println("Aproximação de f(" + targetX + "): " + interpolatedY);
	}

	public static double lagrangeInterpolation(double[] x, double[] y, double targetX) {
		if (x.length != y.length || x.length == 0) {
			throw new IllegalArgumentException("Arrays de tamanhos inválidos.");
		}

		int n = x.length;
		double result = 0;

		for (int i = 0; i < n; i++) {
			double term = y[i];
			StringBuilder interpolation = new StringBuilder("L" + i + "(x) = " + term);

			for (int j = 0; j < n; j++) {
				if (i != j) {
					term = term * (targetX - x[j]) / (x[i] - x[j]);
					interpolation.append(" * (x - " + x[j] + ") / (" + x[i] + " - " + x[j] + ")");
				}
			}

			System.out.println(interpolation);
			result += term;
		}
		return result;
	}
}
