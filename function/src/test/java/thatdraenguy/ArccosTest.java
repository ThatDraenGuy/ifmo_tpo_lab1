package thatdraenguy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArccosTest {
    @Test
    public void illegalPoint() {
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(1.01, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(178, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(-1.01, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(-291, 1);
        });
    }

    @Test
    public void illegalPrecisionDecimals() {
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(0, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(0, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(-0.4, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(0.2, 10);
        });
    }

    @Test
    public void correctArguments() {
        assertDoesNotThrow(() -> {
            Arccos.calculate(0, 1);
            Arccos.calculate(1, 1);
            Arccos.calculate(-1, 1);
            Arccos.calculate(0.259269524, 1);
            Arccos.calculate(-0.259269524, 1);
            Arccos.calculate(0.562, 5);
            Arccos.calculate(-0.91, 6);
            Arccos.calculate(0.83, 0);
            Arccos.calculate(0.25, -4);
        });
    }

    @Test
    public void resultValues() {
        double[] points = new double[]{ -1, -0.97, -0.83, -0.753, -0.6, -0.51, -0.43, -0.37, -0.22, -0.156, 0, 0.156, 0.22, 0.37, 0.43, 0.51, 0.6, 0.753, 0.83, 0.97, 1 };
        double[] results = new double[]{ 3.141592653589793, 2.896027136074501, 2.549904011163249, 
            2.4234057184577593, 2.214297435588181, 2.1059811170704963, 
            2.0152891037307157, 1.9498053474908474, 1.792610797291691, 
            1.7274360940808284, 1.5707963267948966, 1.414156559509, 
            1.3489818562981022, 1.191787306098946, 1.1263035498590777, 
            1.0356115365192968, 0.9272952180016123, 0.7181869351320339,
            0.5916886424265441, 0.24556551751529213, 0 };
        

        for (int point_index = 0; point_index < points.length; point_index++) {
            double point = points[point_index];
            double result = results[point_index];

            for (int precision = 0; precision < 7; precision++) {
                assertEquals(result, Arccos.calculate(point, precision), Math.pow(10, -precision));
            }
        }
    }
}
