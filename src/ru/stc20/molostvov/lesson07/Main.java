package ru.stc20.molostvov.lesson07;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayGen.generateArray();
        Factorial fc = new Factorial();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fc.searchFactorial(array, 0);
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fc.searchFactorial(array, 1);
            }
        }, "thread2").start();
    }
}
