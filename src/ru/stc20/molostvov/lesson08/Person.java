package ru.stc20.molostvov.lesson08;


public class Person {
    private String name;
    private int age;
    private String position;

    Person() {}

    Person(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}