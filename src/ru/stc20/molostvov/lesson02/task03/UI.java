package ru.stc20.molostvov.lesson02.task03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Управление программой
 */

public class UI {
    //Массив объектов Person
    private static Person[] persons;
    public static void main(String[] args) {
        //Переменные для замерения времени выполнения сортировки
        long startTime;
        long stopTime;
        long elapsedTime;

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите 1 - для генерации массива Person, 2 - для просмотра массива," +
                        "3 - для сортировки слиянием, 4 - для quicksort, 0 - для выхода.");
                switch (scanner.nextInt()) {
                    case 1:
                        persons = PersonGenerator.generate();
                        persons[10] = new Person("Вася", 25, "М");
                        persons[20] = new Person("Вася", 20, "М");
                        persons[14] = new Person("Вабся", 20, "М");
                        persons[4] = new Person("Вася", 20, "М");
                        break;
                    case 2:
                        if (persons != null) {
                            UI.printArray(persons);
                        } else {
                            System.out.println("Массив пуст!");
                        }
                        break;
                    case 3:
                        if (persons != null) {
                            Sorting mergeSort = new MergeSort();
                            startTime = System.nanoTime();
                            persons = mergeSort.sort(persons);
                            stopTime = System.nanoTime();
                            elapsedTime = stopTime - startTime;
                            System.out.println(mergeSort.sortName() + " выполнялась " + elapsedTime + " наносекунд.");
                        } else {
                            System.out.println("Массив пуст!");
                        }
                        break;
                    case 4: if (persons != null) {
                        Sorting quickSort = new QuickSort();
                        startTime = System.nanoTime();
                        persons = quickSort.sort(persons);
                        stopTime = System.nanoTime();
                        elapsedTime = stopTime - startTime;
                        System.out.println(quickSort.sortName() + " выполнялась " + elapsedTime + " наносекунд.");
                    } else {
                        System.out.println("Массив пуст!");
                    }
                    break;
                    default:
                        System.out.println("Неверный ввод.");
                        break;
                    case 0 : scanner.close();
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод.");
            }
        }
    }

    /**
     * Выводит в консоль содержание массива
     * @param array - массив типа Person
     */
    private static void printArray(Person[] array) {
        for (Person p : array) {
            System.out.println(p);
        }
    }
}
