package ru.molostvov.task3;

import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;

        System.out.print("Введите первое число: ");
        Scanner sc1 = new Scanner(System.in);
        firstNumber = sc1.nextInt();
        System.out.print("Введите второе число: ");
        Scanner sc2 = new Scanner(System.in);
        secondNumber = sc2.nextInt();

        if (firstNumber == secondNumber) {
            System.out.println("Числа равны");
        } else if (firstNumber > secondNumber) {
            System.out.println("Число " + secondNumber + " меньше");
        } else {
            System.out.println("Число " + firstNumber + " меньше");
        }

        sc1.close();
        sc2.close();
    }
}
