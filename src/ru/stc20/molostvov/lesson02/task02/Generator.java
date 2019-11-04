package ru.stc20.molostvov.lesson02.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Generator {
    private List<Integer> array;
    /**
     * Конструктор класса Generator
     * @param num - размер коллекции
     */
    Generator(int num) {
        array = arrayGen(num);
    }

    /**
     * @param countOfNums - размер коллекции
     * @return - возвращает новую коллекцию нужного размера
     */
    private List<Integer> arrayGen(int countOfNums) {
        List<Integer> arrayWithRandomNums = new ArrayList<>();
        Random random = new Random();
        int number;
        for (int i = 0; i < countOfNums; i++) {
            try {
                number = (random.nextInt(65536)-32768);
                if (number < 0) {
                    throw new GenerationException("Сгенерированное число " + number + " меньше 0," +
                            "поэтому оно не будет добавленно в массив!");
                }
                arrayWithRandomNums.add(number);
                System.out.println("Число " + number + " добавлено!");
                System.out.println(arrayWithRandomNums.toString());

            } catch (GenerationException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        return arrayWithRandomNums;
    }

    /**
     * Функция, проверяющая, равен ли квадрат целой части квадратного корня q изначальному числу k
     * @param listArray - принимает на вход коллекцию рандомных чисел
     */
    void maths (List<Integer> listArray) {
        double tempDouble;
        int tempInt;
        for (int iNum : listArray) {
            tempDouble = Math.sqrt(iNum);
            tempInt = (int) Math. pow(tempDouble, 2);
            if (tempInt == iNum) {
                System.out.println("Число " + iNum + " удовлетворяет условиям");
            }
        }
    }

    List<Integer> getArray() {
        return array;
    }
}
