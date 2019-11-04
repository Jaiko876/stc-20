package ru.stc20.molostvov.lesson02.task03;

import java.util.Random;

public class QuickSort implements Sorting {
    /**
     * Сортировка массива методом quickSort
     * @param array - массив объектов типа Person
     * @return отсортированный массив объектов типа Person
     * @see Sorting
     */
    @Override
    public Person[] sort(Person[] array) {
        return quickSort(array,0, array.length - 1);
    }
    /**
     * Реализация quckSort
     * @param array - массив типа Person
     * @param low - начальный индекс
     * @param high - конечный индекс
     * @return - возвращает массив объектов типа Person
     */
    private Person[] quickSort(Person[] array, int low, int high) {
        if (low < high + 1) {
            int pointer = partition(array, low, high);
            quickSort(array, low, pointer - 1);
            quickSort(array, pointer + 1, high);
        }
        return array;
    }
    /**
     * Метод меняет местами положение объектов в массиве
     * @param array - массив типа Person
     * @param index1 - индекс 1го объекта
     * @param index2 - индекс 2го объекта
     */
    private void swap(Person[] array, int index1, int index2) {
        Person temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Метод возвращает рандомное значение между low и high
     * @param low - начальный индекс массива
     * @param high - конечный индекс массива
     * @return - возвращает рандомное значение между low и high
     */
    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    /**
     * Метод сортирует массив в выбранном диапазоне и возвращает новое значение диапазона для сортировки
     * @param array - массив объектов типа Person
     * @param low - начальный индекс
     * @param high - конечный индекс
     * @return - возвращает новое значение диапазона для сортировки
     */
    private int partition(Person[] array, int low, int high) {
        swap(array, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high ; i++) {
            if (array[i].compareTo(array [low]) < 0) {
                swap(array, i, border++);
            }
        }
        swap(array, low, border - 1);
        return border - 1;
    }

    /**
     * Метод возвращает имя сортировки
     * @return - возвращает название сортировки
     */
    @Override
    public String sortName() {
        return "QuickSort";
    }
}
