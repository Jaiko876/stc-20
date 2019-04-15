package ru.molostvov.task3;

import java.util.Scanner;

public class DescribeNumber {
    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Число равно нулю");
            System.exit(0);
        }

        if (number < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }

        if (number % 2 == 0 && number != 0) {
            System.out.println("Число чётное");
        } else {
            System.out.println("Число нечётное");
        }


    }
}
