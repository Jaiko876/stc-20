package ru.stc20.molostvov.lesson03.task01;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Компаратор для объектов типа Number для воссоздания корректного TreeSet.
 */

public class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number o1, Number o2) {
        return new BigDecimal(o1.toString()).compareTo(new BigDecimal(o2.toString()));
    }
}
