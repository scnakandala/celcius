package algorithms;

public class LinearRegression {

    public static double getRegression(double[] x, double[] y, double val) {
        double zigmaX = 0.0, zigmaY = 0.0, zigmaXY = 0.0, zigmaX2 = 0.0, zigmaY2 = 0.0;
        int n = x.length;
        for (int i = 0; i < n; i++) {
            zigmaX = zigmaX + x[i];
            zigmaY = zigmaY + y[i];

            zigmaX2 = zigmaX2 + x[i] * x[i];
            zigmaY2 = zigmaY2 + y[i] * y[i];

            zigmaXY = zigmaXY + x[i] * y[i];
        }

        double a = (n * zigmaXY - zigmaX * zigmaY) / (n * zigmaX2 - zigmaX * zigmaX);
        double b = (zigmaY * zigmaX2 - zigmaX * zigmaXY) / (n * zigmaX2 - zigmaX * zigmaX);
        return a * val + b;
    }
}
