package ru.molostvov.task3;

import java.util.Scanner;

public class Progressions {
    public static void main(String[] args) {
        int d; // шаг арифметической прогрессии
        int choice; // для выбора прогрессии
        int n; // количество членов прогрессии
        int q; // знаменатель геометрической прогрессии
        int a1; // с какого числа стартует прогрессия

        System.out.print("Выберите прогрессию 1 - арифметическая, 2 - геометрическая: ");
        Scanner scanner1 = new Scanner(System.in);
        choice = scanner1.nextInt();


        switch (choice) {
            case 1: // Арифметическая прогрессия

                System.out.print("Введите количество членов прогрессии: ");
                Scanner scanner2 = new Scanner(System.in);
                n = scanner2.nextInt();
                System.out.print("Введите шаг прогрессии: ");
                Scanner scanner3 = new Scanner(System.in);
                d = scanner3.nextInt();
                System.out.print("Введите стартовое число: ");
                Scanner scanner4 = new Scanner(System.in);
                a1 = scanner4.nextInt();
                System.out.println();

                for (int i = 1; i <= n; i++) {
                    System.out.print((a1 + (i - 1) * d) + " ");
                }

                scanner2.close();
                scanner3.close();
                scanner4.close();
                break;

            case 2: // Геометрическая прогрессия

                System.out.print("Введите количество членов прогрессии: ");
                Scanner scanner5 = new Scanner(System.in);
                n = scanner5.nextInt();
                System.out.print("Введите знаменатель прогрессии: ");
                Scanner scanner6 = new Scanner(System.in);
                q = scanner6.nextInt();
                System.out.print("Введите стартовое число: ");
                Scanner scanner7 = new Scanner(System.in);
                a1 = scanner7.nextInt();
                System.out.println();

                for (int i = 1; i <= n; i++) {
                    System.out.print((long)(a1 * Math.pow(q, (i - 1))) + " ");
                }
                scanner5.close();
                scanner6.close();
                scanner7.close();
                break;

            default:
                System.out.println("Введено не верное значение");
                break;
        }
        scanner1.close();
    }
}
