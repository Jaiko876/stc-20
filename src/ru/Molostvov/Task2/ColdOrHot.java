package ru.Molostvov.Task2;

import java.util.Scanner;

public class ColdOrHot {
    public static void main(String[] args) {
        int a = 1; // Начальное значение диапозона
        int b = 100; // Конечное значение диапозона
        int enteredNumber; // Введенное число
        int prevAttempt = 0; // Предыдущий диапазон до нужного числа
        int thisAttempt = 0; // Диапазон в новой попытке

        int randomNumber = a + (int)(Math.random() * b); // задаём радномное число от 1 до 100
        System.out.println(randomNumber); // включаем читы

        do {
            prevAttempt = thisAttempt; // Передаем диапазон прошлой попытки в нужную переменную
            System.out.print("Введите число от 1 до 100 или 0 для выхода: ");
            Scanner scanner = new Scanner(System.in);
            enteredNumber = scanner.nextInt();

            if(enteredNumber < 0 || enteredNumber > 100){
                while (enteredNumber < 0 || enteredNumber > 100) {
                    System.out.println("Вы ввели недопустимое число");
                    System.out.print("Введите число от 1 до 100 или 0 для выхода: ");
                    enteredNumber = scanner.nextInt();
                }
            }

            if(enteredNumber == randomNumber){
                System.out.println("Вы угадали!");
                System.exit(0);
            }

            if(enteredNumber == 0){
                System.exit(0);
            }
            else {
                if(prevAttempt == 0)
                    prevAttempt = randomNumber; /*до вычисления первого диапазона предыдущий диапазон становится равен
                диапазону от 0 до рандомного числа */
                if (enteredNumber >= randomNumber)
                    thisAttempt = enteredNumber - randomNumber;
                else
                    thisAttempt = randomNumber - enteredNumber;
                if(prevAttempt >= thisAttempt)
                    System.out.println("Горячо!");
                else
                    System.out.println("Холодно!");
            }
        }while (enteredNumber != randomNumber);
    }
}
