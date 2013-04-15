package algorithms;

import java.util.Arrays;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Approximate {

    private double[] xVal, yVal;

    public Approximate(double[] x, double[] y) {
        xVal = x;
        yVal = y;
    }

    public double getApproximatedValue(double val) {
        if (xVal.length > 4) {
            double[] temp = Arrays.copyOf(xVal, xVal.length);
            Arrays.sort(temp);
            double maxVal = temp[temp.length - 1];
            if (val <= maxVal && val >= 0) {//value can ge interpolated
                Spline spline = new Spline(xVal, yVal);
                return spline.spline_value(val);
            } else {//value has to be extrapolated (we use max of quadratic extrapolation and
                //linear regression for the last three points)
                double max_x1 = temp[temp.length - 1], max_x2 = temp[temp.length - 2], max_x3 = temp[temp.length - 3];
                double max_y1 = 0.0, max_y2 = 0.0, max_y3 = 0.0;
                for (int i = 0; i < yVal.length; i++) {
                    if (xVal[i] == max_x1) {
                        max_y1 = yVal[i];
                    } else if (xVal[i] == max_x2) {
                        max_y2 = yVal[i];
                    } else if (xVal[i] == max_x3) {
                        max_y3 = yVal[i];
                    }
                }
                RealMatrix coefficients =
                        new Array2DRowRealMatrix(new double[][]{{max_x1 * max_x1, max_x1, 1}, {max_x2 * max_x2, max_x2, 1}, {max_x3 * max_x3, max_x3, 1}},
                        false);
                DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
                RealVector constants = new ArrayRealVector(new double[]{max_y1, max_y2, max_y3}, false);
                RealVector solution = solver.solve(constants);

                double quadVal = solution.getEntry(0) * val * val + solution.getEntry(1) * val + solution.getEntry(2);

                double regVal = LinearRegression.getRegression(xVal, yVal, val);

                return Math.max(quadVal, regVal);
            }
        }else if(xVal.length==3){
            //linear regression for the last three points)
                RealMatrix coefficients =
                        new Array2DRowRealMatrix(new double[][]{{xVal[0] * xVal[0], xVal[0], 1}, {xVal[1] * xVal[1], xVal[1], 1}, {xVal[2] * xVal[2], xVal[2], 1}},
                        false);
                DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
                RealVector constants = new ArrayRealVector(new double[]{yVal[0], yVal[1], yVal[2]}, false);
                RealVector solution = solver.solve(constants);

                double quadVal = solution.getEntry(0) * val * val + solution.getEntry(1) * val + solution.getEntry(2);

               return quadVal;
        }else if(xVal.length==2){
            double regVal = LinearRegression.getRegression(xVal, yVal, val);
            return regVal;
        }else {//there is logic error
           return 0.0;
        }
    }
}
