package ru.molostvov.task2;

import java.util.Scanner;

public class Fuel {

    public static void main(String[] args) {
        int fuelCost = 43;
        int liters;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество топлива: ");
        liters = scanner.nextInt();
        int forPayment = fuelCost * liters;

        System.out.println("К оплате: " + forPayment + " руб");
    }
}
