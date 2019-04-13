package ru.molostvov.task2;

import java.util.Scanner;

public class RealSalary {

    public static void main(String[] args) {
        int salary;
        int tax;
        int realSalary;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите вашу зарплату: ");
        salary = scanner.nextInt();
        tax = salary * 13 / 100;
        realSalary = salary - tax;

        System.out.println("После вычета налога вы получите: " + realSalary + " руб");
    }
}
