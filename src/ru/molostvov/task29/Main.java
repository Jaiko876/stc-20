package ru.molostvov.task29;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Person> map = createMap();
        System.out.println(map);
        removeTheDublicates(map);
        System.out.println(map);
    }

    private static Map<String, Person> createMap() {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29,"Петрова","жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        return book;
    }

    private static void removeTheDublicates(Map<String, Person> map) {
        Person person = null;
        Map<String, Person> temp = new HashMap<>(map);
        for (Map.Entry<String, Person> me: temp.entrySet()) {
            if (person == null) {
                person = me.getValue();
            } else {
                if (person.hashCode() == me.getValue().hashCode() && person.equals(me.getValue())) {
                    removeItemFromMapByValue(map,person);
                }
                person = me.getValue();
            }
        }

    }

    private static void removeItemFromMapByValue(Map<String, Person> map, Person value) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

}
