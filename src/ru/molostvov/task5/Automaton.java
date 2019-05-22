package ru.molostvov.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class Automaton {
    private static final Logger logger = LoggerFactory.getLogger(Automaton.class);

    private int lastIndex;
    private int moneyOnAccount = 0;

    void checkMenu() {
        logger.info("Проверка меню");
        for (Drinks drinks: Drinks.values()) {
            System.out.println(drinks.getIndex() + ": " + drinks.getName() + " - " + drinks.getCost() + "руб");
            lastIndex = drinks.getIndex();
        }
    }

    void addMoney() {
        logger.info("Пользователь вносит деньги.");
        System.out.print("Внесите деньги: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        try {
            if (input <= 0) {
                System.out.println("Вы не внесли деньги, попробуйте снова!");
                throw new Exception("Пользователь не внес деньги!");
            } else {
                moneyOnAccount += input;
                System.out.println("Всего внесено: " + moneyOnAccount);
                logger.info("На счету пользователя {}руб.", moneyOnAccount);
            }
        } catch(Exception e){
            logger.error("Ошибка, пользователь не внёс деньги!",e);
        }
    }

    void buy() {
        logger.info("Пользователь выбирает напиток.");

        System.out.print("Введите номер напитка: ");
        Scanner scanner1 = new Scanner(System.in);
        int userInput = scanner1.nextInt();

        try {
            if (userInput < 1 || userInput > lastIndex) {
                System.out.println("Вы ввели недопустимое значение!");
                throw new Exception("Введён не верный номер напитка: " + userInput);
            } else {
                for (Drinks drinks : Drinks.values()) {
                    if (userInput == drinks.getIndex()) {
                        System.out.println("Вы выбрали " + drinks.getName() + " по цене " + drinks.getCost() + "руб" +
                                " на вашем счете " + moneyOnAccount + "руб");
                        logger.info("Пользователь выбрал напиток {} по цене {}, на счёте {}руб.",
                                drinks.getName(), drinks.getCost(), moneyOnAccount);
                        if (moneyOnAccount < drinks.getCost()) {
                            System.out.println("Вы внесли недостаточно денег!");
                            throw new Exception("Внесено недостаточно денег!" + moneyOnAccount);
                        } else {
                            System.out.println("Вы купили: " + drinks.getName());
                            logger.info("Операция прошла успешно. Пользователь купил {}", drinks.getName());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            String a = e.toString();
            logger.error(a,e);
        }
    }
}
