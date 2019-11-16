package ru.stc20.molostvov.lesson03.task01;

public class Main {
    public static void main(String[] args) {
        Number[] array = new Number[]{1, 2, 3, 4, 5, 5, 1.0f, 5.2, 11111L, .847d};
        MathBox<Number> mb = new MathBox<>(array);
        MathBox<Number> mb2 = new MathBox<>(array);
        mb.print();
        mb.splitter(2);
        mb.print();
        mb.summator();
        mb.removeElement(2);
        mb.print();
        System.out.println(mb.equals(mb2));
        System.out.println(mb.hashCode());
        System.out.println(mb.hashCode());
        System.out.println(mb2.hashCode());

        ObjectBox ob = new ObjectBox();
        ObjectBox ob2 = new MathBox<>(array);
        ob.addObject(10);
        ob.addObject(mb);
        ob.addObject(mb2);
        ob.dump();
        mb.dump();
        ob2.addObject(mb2);

    }
}
