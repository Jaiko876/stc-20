package ru.stc20.molostvov.lesson02.task03;

import java.util.Random;

class Person implements Comparable<Person> {
    private Sex sex;
    private int age;
    private String name;

    /**
     * Конструктор Person, возраст генерируется рандомно.
     * @param name - имя
     * @param sex - пол
     */
    Person(String name, String sex) {
        Random rand = new Random();
        this.name = name;
        age = rand.nextInt(101);
        switch (sex) {
            case "Ж" : this.sex = Sex.WOMAN; break;
            case "М" : this.sex = Sex.MAN; break;
        }
    }

    /**
     * Дополнительный конструктор для мануального создания новых Person
     * @param name - имя
     * @param age - возраст
     * @param sex - пол
     */
    Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        switch (sex) {
            case "Ж":
                this.sex = Sex.WOMAN;
                break;
            case "М":
                this.sex = Sex.MAN;
                break;
        }
    }

    /**
     * Переопределение метода toString
     * @return возвращает отображение объекта в виде строки
     */
    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Возвращает имя Person
     * @return - возвращает имя Person
     */
    public String getName() {
        return name;
    }

    /**
     * Алгоритм сравнения объектов Person
     * @param o - объект типа Person
     * @return - возвращает целое число, равное -1 если объект меньше, 0 если объекты равны или 1 если объект больше
     */
    @Override
    public int compareTo(Person o) {
        int result = sex.compareTo(o.sex);
        if (result != 0) {
            return result;
        }
        result = age - o.age;
        if (result != 0) {
            return -result;
        }

        result = name.compareToIgnoreCase(o.name);
        try {
            if (age == o.age && result == 0) {
                throw new NameException(o);
            }
        } catch (Exception e) {
            result = name.compareToIgnoreCase(o.name);
            return result;
        }
        return result;
    }

    /**
     * Метод устанавливает имя Person
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }
}
