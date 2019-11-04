package ru.stc20.molostvov.lesson02.task03;

public interface Sorting {
    /**
     * Метод sort принимает несортированный массив и возвращает отсортированный
     * @param array - массив объектов типа Person
     * @return - возвращает отсортированный массив типа Person
     */
    Person[] sort(Person[] array);

    /**
     * Метод возвращает название сортировки
     * @return - поле типа String с названием сортировки
     */
    String sortName();
}
