package ru.molostvov.task25.mapFilter;

import java.util.HashMap;
import java.util.Map;

public class MapFilter {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        System.out.println(isUnique(map));

        map.put("Вася","Иванов");
        map.put("Петр","Петров");
        map.put("Виктор","Сидоров");
        map.put("Сергей","Савельев");
        map.put("Вадим","Викторов");

        System.out.println(map.values());
        System.out.println(isUnique(map));

        Map<String,String> secondMap = new HashMap<>();
        secondMap.put("Вася","Иванов");
        secondMap.put("Петр","Петров");
        secondMap.put("Виктор","Иванов");
        secondMap.put("Сергей","Савельев");
        secondMap.put("Вадим","Петров");

        System.out.println(secondMap.values());
        System.out.println(isUnique(secondMap));

    }

    private static boolean isUnique(Map<String,String> map) {
        if (map.isEmpty()) {
            return true;
        }
        String tempValue = null;
        for (String value : map.values()) {
           if (tempValue != null && tempValue.equalsIgnoreCase(value)) {
                return false;
           }
           tempValue = value;
        }
        return true;
    }

}
