package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunctionThenQuadraticResult() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> 2 * Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(4D, 11D, 22D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionThenQuadraticResult() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(16D, 32D, 64D);
        assertThat(result).containsAll(expected);
    }
}