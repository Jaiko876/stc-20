package ru.stc20.molostvov.lesson05;

import ru.stc20.molostvov.lesson02.task03.Sex;

import java.util.Random;
import java.util.UUID;

/**
 * Класс Person
 * @author Игорь Молоствов
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Sex sex;
    private final UUID uuid = UUID.randomUUID();

    Person(String name, String sex) {
        Random rand = new Random();
        this.name = name;
        age = rand.nextInt(101);
        switch (sex) {
            case "Ж" : this.sex = Sex.WOMAN; break;
            case "М" : this.sex = Sex.MAN; break;
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        if (sex != person.sex) return false;
        return uuid.equals(person.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
