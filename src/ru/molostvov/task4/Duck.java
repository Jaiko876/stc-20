package ru.molostvov.task4;

public class Duck extends Bird {
    public Duck(String birdName) {
        super(birdName);
    }

    @Override
    protected void swim() {
        super.swim();
        System.out.println("Иногда уточки еще ныряют!");
    }
}
