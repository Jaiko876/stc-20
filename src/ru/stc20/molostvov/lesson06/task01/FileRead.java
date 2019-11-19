package ru.stc20.molostvov.lesson06.task01;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead {
    private static Collection<String> strings = new TreeSet<>(String::compareToIgnoreCase);

    public static void main(String[] args) {
        String line = null;
        String fullString = "";
        File file = new File("src/ru/stc20/molostvov/lesson06/task01/new 7.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                fullString += " " + line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("[А-Яа-я]+",
                Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fullString);
        while (matcher.find()) {
            strings.add(matcher.group());
        }
        System.out.println(strings);
    }
}
