package ru.molostvov.task4;

public class Swan extends Bird{
    public Swan(String birdName) {
        super(birdName);
    }
    protected void fly() {
        System.out.println("Лебеди иногда летают вокруг пруда!");
    }
}
