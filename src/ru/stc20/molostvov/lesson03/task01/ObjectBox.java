package ru.stc20.molostvov.lesson03.task01;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс который создает коллекцию объектов
 */

public class ObjectBox {
    private List<Object> objectList = new ArrayList<>();

    /**
     * Добавляет объект в коллекцию
     * @param o - объект
     */
    public void addObject(Object o) {
        objectList.add(o);
    }

    /**
     * Удаляет объект из коллекции
     * @param o - объект
     */
    public void deleteObject(Object o) {
        objectList.remove(o);
    }

    /**
     * Выводит содержимое коллекции
     */
    void dump() {
        System.out.println(objectList);
    }
}
