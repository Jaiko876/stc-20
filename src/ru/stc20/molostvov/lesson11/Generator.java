package ru.stc20.molostvov.lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

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
                number = (random.nextInt(15)- 5);
                Predicate<Integer> isPositive = (n) -> n > 0;
                if (isPositive.negate().test(number)) {
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
       System.out.println("Числа удовлетворяющие условию: ");
        listArray.stream().filter(n -> (int) Math.pow((int) Math.sqrt(n), 2) == n).distinct().forEach(System.out::println);
    }

     List<Integer> getArray() {
        return array;
    }

    /**
     * Функция, которая принимает функцию как параметр
     * @param list - коллекция
     * @param func - функция
     */
    void doMaths (List<Integer> list, Maths<Integer> func) {
        func.doMath(list);
    }
}
