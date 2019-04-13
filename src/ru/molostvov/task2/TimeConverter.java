package ru.molostvov.task2;

import java.util.Scanner;

public class TimeConverter {

    public static void main(String[] args) {
        int seconds;
        int convertedToHours;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество секунд для конвертации в часы: ");
        seconds = scanner.nextInt();
        convertedToHours = seconds / 3600;

        System.out.println(seconds + " в часах = " + convertedToHours);
    }
}
