package ru.molostvov.task7;

abstract class Animal {
    abstract void getName();
}

class Cow extends Animal implements Run{
    Cow() {
        getName();
    }

    void getName() {
        System.out.println("Корова");
    }

    public void run(){
        System.out.println("Корова бежит");
    }
}

class Dog extends Animal implements Run, Swim {
    Dog(){
        getName();
    }

    void getName() {
        System.out.println("Собака");
    }

    public void run(){
        System.out.println("Собака бежит");
    }

    public void swim() {
        System.out.println("Собака плывет");
    }
}

class Duck extends Animal implements Run, Swim, Fly {
    Duck() {
        getName();
    }
    void getName() {
        System.out.println("Утка");
    }

    public void run() {
        System.out.println("Утка бежит");
    }

    public void swim() {
        System.out.println("Утка плывет");
    }

    public void fly() {
        System.out.println("Утка летит");
    }
}

class Main {
    public static void main(String[] args) {
        Cow cow = new Cow();
        Dog dog = new Dog();
        Duck duck = new Duck();

        cow.run();
        dog.swim();
        dog.run();
        duck.run();
        duck.swim();
        duck.fly();
    }
}
