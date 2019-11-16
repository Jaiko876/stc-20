package ru.stc20.molostvov.lesson03.task01;

import java.util.*;

/**
 * Класс, осуществляющий сложение, деление чисел в коллекции и удаление нужного эллемента.
 * @param <T> - обобщенный тип наследуемый от Number.
 */

public class MathBox <T extends Number> extends ObjectBox{
    private Set<T> treeSet;
    private final UUID uuid = UUID.randomUUID();

    /**
     * Конструктор класса
     * @param array - массив типа T - Number, либо один из наследников этого класса
     */
    MathBox(T [] array) {
        treeSet = new TreeSet<>(new NumberComparator());
        treeSet.addAll(Arrays.asList(array));
    }

    /**
     * Метод выполняет суммирование всех эллементов внутри коллекции, приводя любой из Number к примитиву double.
     */
    void summator() {
        double sum = 0;
        for (T t1: treeSet) {
            sum += t1.doubleValue();
        }
        System.out.println(sum);
    }

    /**
     * Медот выполняет деление каждого эллемента коллекции на аргумент и заменяет значения коллекции на новые.
     * @param arg - аргумент, число типа T на которое нужно разделить каждый эллемент коллекции. Приводится к примитиву
     * типа double.
     */
    void splitter(T arg) {
        double d = arg.doubleValue();
        Set<T> newTreeSet = new TreeSet<>(new NumberComparator());
        for (T t1 : treeSet) {
            T result = split(t1, d);
            newTreeSet.add(result);
        }
        treeSet = newTreeSet;
    }

    /**
     * Внутренняя реализация метода splitter, принимает делимое типа T и делитель приведенный к double.
     * @param first - делимое типа T
     * @param d - делитель double
     * @return возвращает число типа T
     */
    private T split (T first, double d) {
        return (T) new Double(first.doubleValue()/d);
    }

    /**
     * Метод, который вызывает уже существующий метод для удаления эллемента из коллекции.
     * @param i - число, которое необходимо удалить.
     */
    void removeElement(int i) {
        treeSet.remove(i);
    }

    void print () {
        System.out.println(treeSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathBox<?> mathBox = (MathBox<?>) o;

        if (treeSet != null ? !treeSet.equals(mathBox.treeSet) : mathBox.treeSet != null) return false;
        return uuid.equals(mathBox.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "treeSet=" + treeSet +
                '}';
    }
    @Override
    public void addObject(Object o) {
        try {
            throw new Exception("Вы не можете добавить объект из класса MathBox");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
