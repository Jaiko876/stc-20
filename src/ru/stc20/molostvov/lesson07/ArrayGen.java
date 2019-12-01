package ru.stc20.molostvov.lesson07;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс генерирует массив чисел типа int.
 * @author Игорь Молоствов.
 */

public class ArrayGen {
    public static int [] generateArray() {
        Random rand = new Random(System.nanoTime());
        int amount = rand.nextInt(40);
        int [] array = new int[amount];
        for (int i = 0; i < amount ; i++) {
            array[i] = rand.nextInt(50);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
