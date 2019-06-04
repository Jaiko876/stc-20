package ru.molostvov.task19;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Check {
    private final static String NAME = "Наименование";
    private final static String COST = "Цена";
    private final static String AMOUNT = "Кол-во";
    private final static String PRISE = "Стоимость";
    private final static String ITOGO = "Итого:";
    private final static String COOLLINE = "==================================================";
    private static float sum = 0;

    public static void main(String[] args) throws IOException {

        final
        String filename = "src/ru/molostvov/task19/products.txt";
        String string = "";
        float floatPrise;
        float floatAmount;
        int intAmount;
        int intPrise;
        float totalPrise;

        System.out.printf("%-20s%-9s%-12s%-10s%n",NAME,COST,AMOUNT,PRISE);
        System.out.println(COOLLINE);

        try (FileReader fr = new FileReader(filename);
             Scanner scanner = new Scanner(fr)) {
            scanner.useLocale(Locale.ENGLISH);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    intAmount = scanner.nextInt();
                    if (scanner.hasNextInt()) {
                        intPrise = scanner.nextInt();
                        System.out.printf("%-6s X %-12s ", intPrise, intAmount);
                        totalPrise = intAmount * intPrise;
                        System.out.printf("=%5.2f%n", totalPrise);
                        sum += totalPrise;
                    } else if (scanner.hasNextFloat()) {
                        floatPrise = scanner.nextFloat();
                        System.out.printf("%-6s X %-12s ", floatPrise, intAmount);
                        totalPrise = intAmount * floatPrise;
                        sum += totalPrise;
                        System.out.printf("=%5.2f%n", totalPrise);
                    }
                } else if (scanner.hasNextFloat()) {
                  floatAmount = scanner.nextFloat();
                  if (scanner.hasNextInt()) {
                      intPrise = scanner.nextInt();
                      System.out.printf("%-6s X %-12s ", intPrise, floatAmount);
                      totalPrise = floatAmount * intPrise;
                      sum += totalPrise;
                      System.out.printf("=%5.2f%n", totalPrise);
                  } else if (scanner.hasNextFloat()) {
                      floatPrise = scanner.nextFloat();
                      System.out.printf("%-6s X %-12s ", floatPrise, floatAmount);
                      totalPrise = floatAmount * floatPrise;
                      sum += totalPrise;
                      System.out.printf("=%5.2f%n", totalPrise);
                  }
                } else {
                    string = scanner.nextLine();
                    if (!string.equals("")) {
                        System.out.printf("%-20s", string);
                    }
                }
            }
            System.out.println(COOLLINE);
            System.out.printf("%-43s%5.2f", ITOGO, sum);
        }
    }
}
