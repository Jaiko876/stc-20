package ru.molostvov.task4;

public class Humans {
    private String name;

    protected void walk() {
        System.out.println(this.name + " пришел(а) на пруд!");
    }

    protected void watch() {
        System.out.println(this.name + " смотрит на пруд!");
    }

    public Humans(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
