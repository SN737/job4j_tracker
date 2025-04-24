package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {
    @Test
    void whenDistance2dFromX1Y2toX4Y6Then5() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);
        double result = p1.distance(p2);
        double expected = 5;
        assertThat(result).isCloseTo(expected, withPrecision(0.01));
    }

    @Test
    void whenDistance3dFromX1Y2Z4toX4Y6Z8Then6dot4() {
        Point p1 = new Point(1, 2, 4);
        Point p2 = new Point(4, 6, 8);
        double result = p1.distance3d(p2);
        double expected = 6.4;
        assertThat(result).isCloseTo(expected, withPrecision(0.01));
    }

    @Test
    void whenDistance3dFromX0Y0Z0toX1Y1Z1Then1dot73() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 1, 1);
        double result = p1.distance3d(p2);
        double expected = 1.73;
        assertThat(result).isCloseTo(expected, withPrecision(0.01));
    }

    @Test
    void whenDistance3dFromNeg1Neg2Neg3ToNeg4Neg6Neg8Then7dot07() {
        Point p1 = new Point(-1, -2, -3);
        Point p2 = new Point(-4, -6, -8);
        double result = p1.distance3d(p2);
        double expected = 7.07;
        assertThat(result).isCloseTo(expected, withPrecision(0.01));
    }

}
