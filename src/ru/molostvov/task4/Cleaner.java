package ru.molostvov.task4;

public class Cleaner extends Humans{
    public Cleaner(String name) {
        super(name);
    }

    protected void Cleaning(Pond pond) {
        System.out.println(this.getName() + " чистит пруд!");
        pond.setI(0);
        pond.pondStatus();
    }

    @Override
    protected void walk() {
        System.out.println("Уборщик " + this.getName() + " пришел на пруд!");
    }
}
