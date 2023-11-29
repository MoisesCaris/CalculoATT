package minimos;

public class Minimos2 {
	public static void main(String[] args) {
		double[] x = { -2, 0, 2, 3, 5 };
		double[] y = { 6, 3, 2, 1, -6 };

		double targetX = 1;
		int target = (int) targetX;

		double[] coefficients = leastSquaresFit(x, y);

		double m = coefficients[0];
		double b = coefficients[1];

		System.out.println("Equação da Reta: y = " + m + "  x + " + b);

		double approximatedY = m * targetX + b;
		System.out.println("Aproximação de f(" + target + "): " + approximatedY);
	}

	public static double[] leastSquaresFit(double[] x, double[] y) {
		if (x.length != y.length || x.length == 0) {
			throw new IllegalArgumentException("Arrays de tamanhos inválidos.");
		}

		int n = x.length;
		double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

		for (int i = 0; i < n; i++) {
			sumX += x[i];
			sumY += y[i];
			sumXY += x[i] * y[i];
			sumX2 += x[i] * x[i];
		}

		double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
		double b = (sumY - m * sumX) / n;

		return new double[] { m, b };
	}
}
