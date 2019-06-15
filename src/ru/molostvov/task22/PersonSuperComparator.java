package ru.molostvov.task22;

import java.util.Comparator;

public class PersonSuperComparator implements Comparator <Person>{
    @Override
    public int compare(Person p1, Person p2) {
        int result =  p1.getName().compareTo(p2.getName());
        int result2 = p1.getAge() - p2.getAge();
        if (result != 0) {
            return result;
        } else {
            return  result2;
        }
    }
}
