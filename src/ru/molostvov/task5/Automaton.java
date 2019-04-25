package ru.molostvov.task5;

import java.util.Scanner;

class Automaton {
    private int lastIndex;
    private int moneyOnAccount = 0;

    void checkMenu() {
        for (Drinks drinks: Drinks.values()) {
            System.out.println(drinks.getIndex() + ": " + drinks.getName() + " - " + drinks.getCost() + "руб");
            lastIndex = drinks.getIndex();
        }
    }

    void addMoney() {
        System.out.print("Внесите деньги: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input <= 0 ) {
            System.out.println("Вы не внесли деньги, попробуйте снова!");
        } else {
            moneyOnAccount += input;
            System.out.println("Всего внесено: " + moneyOnAccount);
        }
    }

    void buy() {
        System.out.print("Введите номер напитка: ");
        Scanner scanner1 = new Scanner(System.in);
        int userInput = scanner1.nextInt();

        if (userInput < 1 || userInput > lastIndex) {
            System.out.println("Вы ввели недопустимое значение!");
        } else {
            for (Drinks drinks : Drinks.values()) {
                if (userInput == drinks.getIndex()) {
                    System.out.println("Вы выбрали " + drinks.getName() + " по цене " + drinks.getCost() + "руб" +
                            " на вашем счете " + moneyOnAccount + "руб");
                    if (this.moneyOnAccount < drinks.getCost()) {
                        System.out.println("Вы внесли недостаточно денег!");
                        break;
                    } else {
                        System.out.println("Вы купили: " + drinks.getName());
                        break;
                    }
                }
            }
        }
    }
}
