package ru.stc20.molostvov.lesson07;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Класс вычисляет факториал каждого числа в массиве, есть общий хеш на оба потока.
 * @author Игорь Молоствов.
 */

public class Factorial {
    private static ConcurrentNavigableMap<Integer, BigInteger> hash = new ConcurrentSkipListMap<>();
    private static volatile int pointer;

    /**
     * Метод организован, чтобы работать с двумя потоками - один работает с первой половиной массива, второй -
     * со второй. Вычисляет факториал чисел в массиве.
     * @param array - массив чисел
     * @param mode - если 0, то поток работает с первой частью массива.
     */

    public void searchFactorial(int[] array, int mode) {
        if (pointer == 0) {
            pointer = array.length / 2;
        }
        if (mode == 0) {
            for (int i = 0; i < pointer; i++) {
                countF(array[i]);
            }
        } else {
            for (int i = pointer; i < array.length; i++) {
                countF(array[i]);
            }
        }
    }

    /**
     * Логика вычислений факториала.
     * @param num - число, факториал которого ищется.
     */
    private void countF(int num) {
        BigInteger factorial = checkHash(num);
        if (factorial.compareTo(BigInteger.valueOf(1)) == 0) {
            return;
        } else if (!factorial.equals(BigInteger.valueOf(0))) {
            System.out.println("Факториал числа " + num + " равен " + factorial);
            hash.put(num, factorial);
            return;
        }
        synchronized (this) {
            if (num == 0) {
                System.out.println("Факториал числа " + num + " равен 0");
            } else {
                for (int j = 0; j < num; j++) {
                    if (j + 1 == 1) {
                        factorial = BigInteger.valueOf(j + 1);
                    }
                    factorial = factorial.multiply(BigInteger.valueOf(j + 1));
                }
                hash.put(num, factorial);
                System.out.println("Факториал числа " + num + " равен " + factorial);
            }
        }
    }

    /**
     * Метод проверяет захешированные значения.
     * @param num - число
     * @return - возвращает 0, если нет совпадений или хеш пуст; 1 - если факториал числа уже есть в хеше;
     * либо вызывает функцию подсчёта факториала от ближайшего известного захешированного числа, если на это требуется
     * меньше операций, чем при подсчете факториала от 1.
     */
    private BigInteger checkHash(int num) {
        if (hash.size() < 1) {
            return BigInteger.valueOf(0);
        } else if (hash.containsKey(num)) {
            BigInteger factorial = hash.get(num);
            System.out.println("Факториал числа " + num + " равен " + factorial);
            return BigInteger.valueOf(1);
        } else if (hash.floorKey(num) != null && num - hash.floorKey(num) < num) {
            int closestKey = hash.floorKey(num);
            return countUsingHash(num, closestKey);
        } else if (hash.ceilingKey(num) != null && hash.ceilingKey(num) - num < num) {
            int closestKey2 = hash.ceilingKey(num);
            return countUsingHash(num, closestKey2);
        } else {
            return BigInteger.valueOf(0);
        }
    }

    /**
     * Логика подсчёта факториала от ближайших захешированных значений.
     * @param num - число, факториал которого ищется.
     * @param key - ключ от хеш-мапы
     * @return возвращает факториал числа num.
     */
    private synchronized BigInteger countUsingHash(int num, int key) {
        BigInteger factorial = hash.get(key);
        if (key > num) {
            for (int i = key; i >= num; i--) {
                factorial = factorial.divide(BigInteger.valueOf(i));
            }
            return factorial;
        } else {
            for (int i = key; i < num ; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i + 1));
            }
            return factorial;
        }
    }
}
