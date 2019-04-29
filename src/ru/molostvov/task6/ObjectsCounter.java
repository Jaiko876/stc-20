package ru.molostvov.task6;

public class ObjectsCounter {
    private static  int counter = 0;
    private ObjectsCounter() {
        counter++;
    }

    public static void main(String[] args) {
        ObjectsCounter obj1 = new ObjectsCounter();
        ObjectsCounter obj2 = new ObjectsCounter();
        ObjectsCounter obj3 = new ObjectsCounter();
        System.out.println(counter);
    }
}
