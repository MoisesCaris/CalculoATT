package newtom;

public class Newtom1 {
	private static final int MAX_ITERACOES = 100;

    public static void main(String[] args) {
        double x0 = 0.1;
        double precisao = 1e-3;

        double[] resultado = encontrarRaiz(x0, precisao);

        if (Double.isNaN(resultado[0])) {
            System.out.println("Não foi possível encontrar raiz dentro da precisão desejada.");
        } else {
            System.out.println("Raiz positiva encontrada: " + resultado[0]);
            System.out.println("Precisão alcançada (|f(x)| / |f'(x)|): " + resultado[1]);
        }
    }

    public static double[] encontrarRaiz(double x0, double precisao) {
        double x = x0;
        int iteracao = 0;

        while (Math.abs(funcao(x)) > precisao && iteracao < MAX_ITERACOES) {
            x = x - funcao(x) / derivada(x);

            iteracao++;
            System.out.println("Iteração " + iteracao + ": x = " + x + ", erro: " + Math.abs(funcao(x)) / Math.abs(derivada(x)));
        }

        if (iteracao >= MAX_ITERACOES) {
            return new double[]{Double.NaN, Double.NaN};
        }

        return new double[]{x, Math.abs(funcao(x)) / Math.abs(derivada(x))};
    }

    public static double funcao(double x) {
        return Math.pow(x, 4) - Math.pow(3 * x, 2) + 5;
    }

    public static double derivada(double x) {
        return Math.pow(4 * x, 3) - 6 * x;
    }
}