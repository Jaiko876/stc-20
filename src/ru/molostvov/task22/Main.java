package ru.molostvov.task22;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonSuperComparator psm = new PersonSuperComparator();
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Вася",22));
        personArrayList.add(new Person("Вася",22));
        personArrayList.add(new Person("Петя",37));
        personArrayList.add(new Person("Анатолий",22));
        personArrayList.add(new Person("Анатолий",62));

        for (Person p: personArrayList) {
            System.out.println(p);
        }

        System.out.println(psm.compare(personArrayList.get(0),personArrayList.get(1)));
        System.out.println(psm.compare(personArrayList.get(0),personArrayList.get(2)));
        System.out.println(psm.compare(personArrayList.get(2),personArrayList.get(3)));
        System.out.println(psm.compare(personArrayList.get(2),personArrayList.get(1)));
    }
}
