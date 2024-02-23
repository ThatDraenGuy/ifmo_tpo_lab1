package thatdraenguy;


public class Arccos {
    private static final int MAX_PRECISION_DECIMALS = 6;

    public static double calculate(double point, int precisionDecimals) {
        if (point < -1. || point > 1.) {
            throw new IllegalArgumentException("Cannot calculate arccos at a point outside of [-1; 1] range!");
        }

        if (precisionDecimals > MAX_PRECISION_DECIMALS) {
            throw new IllegalArgumentException("Cannot calcualte with precision bigger than 6 decimal points!");
        }
        
        if (precisionDecimals <= 0)
            precisionDecimals = 0;

        int stepsNumber = precisionDecimals + 2;

        boolean isNegative = point < 0;
        point = isNegative ? -point : point;

        boolean isNearZero = point < 0.5;

        double result = 0;
        for (int index = 0; index < stepsNumber; index++) {
            result += getTerm(index, point, isNearZero);
        }

        if (isNearZero)
            result = Math.PI / 2 - result;
        else {
            result *= Math.sqrt(2 * (1 - point));
        }

        if (isNegative)
            result = Math.PI - result;
            

        return result;
    }

    private static double getTerm(int index, double point, boolean isNearZero) {
        double num = isNearZero ? Math.pow(point, 2 * index + 1) : Math.pow(2, -index) * Math.pow(1 - point, index);
        return num * getFactorial(2 * index) /
            ( Math.pow(2, 2 * index) * Math.pow(getFactorial(index), 2) * ( 2 * index + 1 ) );
        // return getFactorial(2 * index) * Math.pow(2, -index) * Math.pow(1 - point, index) /
        //     ( Math.pow(2, 2 * index) * Math.pow(getFactorial(index), 2) * ( 2 * index + 1 ) );
    }

    private static int getFactorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
