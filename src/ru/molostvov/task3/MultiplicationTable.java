package ru.molostvov.task3;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int multiplicationLenght;
        int num;

        Scanner scanner = new Scanner(System.in);
        System.out.print("До какого числа вам нужна таблица умножения: ");
        multiplicationLenght = scanner.nextInt();

        for (int i = 1; i <=multiplicationLenght; i++) {
            for (int j = 1; j <= 10 ; j++) {
                num = i*j;
                System.out.println(i + " * " + j + " = " + num);
            }
            System.out.println();
        }
        scanner.close();
    }
}
