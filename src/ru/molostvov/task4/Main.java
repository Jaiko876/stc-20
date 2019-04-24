package ru.molostvov.task4;

public class Main {
    public static void main(String[] args) {
        Pond pond = new Pond();
        Duck duck = new Duck("Утка");
        duck.swim();
        Swan swan = new Swan("Лебедь");
        swan.fly();
        swan.swim();
        pond.pondStatus();
        Visitors visitor = new Visitors("Алеша");
        visitor.walk();
        visitor.watch();
        Youth youth = new Youth("Анатолий");
        youth.walk();
        youth.watch();
        youth.drinking(pond);
        pond.pondStatus();
        Cleaner cleaner = new Cleaner("Василий");
        cleaner.walk();
        cleaner.Cleaning(pond);
    }
}
