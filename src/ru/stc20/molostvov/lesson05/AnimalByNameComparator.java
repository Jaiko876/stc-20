package ru.stc20.molostvov.lesson05;

import java.util.Comparator;

/**
 * Переопределенный компаратор отличный от принципов сравнения в классе Animal, выполняет сортировку объектов типа
 * Animal по имени.
 * @author Игорь Молоствов
 */

public class AnimalByNameComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
