package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperations(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);

    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(minus(3));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.divide(15));
        System.out.println(calculator.sumAllOperations(3));

    }
}