package thatdraenguy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class ArccosTest {
    @ParameterizedTest
    @ValueSource(doubles = { 1.01, 178, -1.01, -291 })
    public void illegalPoint(double point) {
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(point, 1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { 20, 10, 14, 100 })
    public void illegalPrecisionDecimals(int precisionDecimals) {
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(0, precisionDecimals);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Arccos.calculate(-0.95, precisionDecimals);
        });
    }

    @ParameterizedTest
    @MethodSource
    public void correctArguments(double[] args) {
        assertDoesNotThrow(() -> {
            Arccos.calculate(args[0], (int) args[1]);
        });
    }

    private static Stream<double[]> correctArguments() {
        return Stream.of(new double[] { 0, 1 }, new double[] { 1, 1 }, new double[] { -1, 1 },
                new double[] { 0.259269524, 1 }, new double[] { -0.259269524, 1 }, new double[] { 0.562, 5 },
                new double[] { -0.91, 6 }, new double[] { 0.83, 0 }, new double[] { 0.25, -4 });
    }

    @ParameterizedTest
    @MethodSource
    public void resultValues(double[] values) {
        double point = values[0];
        double result = values[1];

        for (int precision = 0; precision < 7; precision++) {
            assertEquals(result, Arccos.calculate(point, precision), Math.pow(10, -precision));
        }
    }

    private static Stream<double[]> resultValues() {
        return Stream.of(new double[] { -1, 3.141592653589793 }, new double[] { -0.97, 2.896027136074501 },
                new double[] { -0.83, 2.549904011163249 }, new double[] { -0.753, 2.4234057184577593 },
                new double[] { -0.6, 2.214297435588181 }, new double[] { -0.51, 2.1059811170704963 },
                new double[] { -0.43, 2.0152891037307157 }, new double[] { -0.37, 1.9498053474908474 },
                new double[] { -0.22, 1.792610797291691 }, new double[] { -0.156, 1.7274360940808284 },
                new double[] { 0, 1.5707963267948966 }, new double[] { 0.156, 1.414156559509 },
                new double[] { 0.22, 1.3489818562981022 }, new double[] { 0.37, 1.191787306098946 },
                new double[] { 0.43, 1.1263035498590777 }, new double[] { 0.51, 1.0356115365192968 },
                new double[] { 0.6, 0.9272952180016123 }, new double[] { 0.753, 0.7181869351320339 },
                new double[] { 0.83, 0.5916886424265441 }, new double[] { 0.97, 0.24556551751529213 },
                new double[] { 1, 0 });
    }
}
