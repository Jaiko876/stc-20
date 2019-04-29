package ru.molostvov.task6;

public class Calculator {

    static int sum(int a, int b) {
        return a + b;
    }

    static double sum(double a, double b) {
        return  a + b;
    }

    static int subtraction(int a, int b) {
        return a - b;
    }

    static double subtraction(double a, double b) {
        return a - b;
    }

    static int multiplication(int a, int b) {
        return  a * b;
    }

    static double multiplication(double a, double b) {
        return a * b;
    }

    static int division(int a, int b) {
        return a / b;
    }

    static double division(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(sum(2.5, 4.6));
        System.out.println(sum(1,2));
        System.out.println(subtraction(3,2));
        System.out.println(subtraction(2.54,1.3));
        System.out.println(multiplication(2,2));
        System.out.println(multiplication(2.4,2.6));
        System.out.println(division(4,3));
        System.out.println(division(4.0,3.0));

    }
}
