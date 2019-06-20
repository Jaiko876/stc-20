package ru.molostvov.task24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringFilter {
    public static void main(String[] args) {
        String[] strings = new String[]{"foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"};
        Set<String> set = addInSet(strings);
        System.out.println(set);
        set = removeEvenLength(set);
        System.out.println(set);
    }

    private static Set<String> addInSet(String[] strings) {
        return new HashSet<>(Arrays.asList(strings));
    }

    private static Set<String> removeEvenLength(Set<String> set) {
        Set<String> newSet = new HashSet<>();
        for (String string : set) {
            if (string.length() % 2 != 0) {
                newSet.add(string);
            }
        }

        return newSet;
    }
}
