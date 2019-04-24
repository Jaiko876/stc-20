package ru.molostvov.task4;

public class Pond {
    private int i;
    protected void pondStatus() {
        int i = this.i;
        if (i == 1) {
            System.out.println("Пруд загрязнен!");
        } else {
            System.out.println("Пруд чистый!");
        }
    }

    public void setI(int i) {
        this.i = i;
    }
}
