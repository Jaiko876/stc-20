package ru.molostvov.task8;

import java.util.Scanner;

public class Censor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        System.out.println(input.replaceAll("бяка", "вырезано цензурой"));
        scanner.close();
    }
}
