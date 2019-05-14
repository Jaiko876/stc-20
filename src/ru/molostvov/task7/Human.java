package ru.molostvov.task7;

abstract class Human implements Run, Swim{
    public abstract void run();
    public abstract void swim();
}

class Ivan extends Human {
    public void run() {
        System.out.println("Иван бежит!");
    }
    public void swim() {
        System.out.println("Иван плывет!");
    }
}

class Andrey extends Human {
    public void run() {
        System.out.println("Андрей бежит!");
    }
    public void swim() {
        System.out.println("Андрей плывет!");
    }
}

class WithMain {
    public static void main(String[] args) {
        Ivan ivan = new Ivan();
        Andrey andrey = new Andrey();
        ivan.run();
        ivan.swim();
        andrey.run();
        andrey.swim();
    }
}