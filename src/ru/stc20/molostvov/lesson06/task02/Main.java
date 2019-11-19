package ru.stc20.molostvov.lesson06.task02;

public class Main {
    public static void main(String[] args) {
        WordGen wg = new WordGen();
        String[] strings = wg.generateWordArray();
        FileWriterxxx fw = new FileWriterxxx();
        fw.getFiles("src/ru/stc20/molostvov/lesson06/task02/textFiles", 5, 100, strings, 1);
    }
}
