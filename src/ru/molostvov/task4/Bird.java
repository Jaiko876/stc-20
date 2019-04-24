package ru.molostvov.task4;

public class Bird {
    private String birdName;

    protected void swim() {
        System.out.println(this.birdName + " плавает в пруду");
    }

    public Bird(String birdName) {
        this.birdName = birdName;
    }
}
