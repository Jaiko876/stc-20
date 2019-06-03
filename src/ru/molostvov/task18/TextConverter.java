package ru.molostvov.task18;

import java.io.*;

public class TextConverter {
    public static void main(String[] args) throws IOException {
        String fileName1 = "src/ru/molostvov/task18/UTF8.txt";
        String fileName2 = "src/ru/molostvov/task18/windows1251.txt";
        String text = "Привет, мир!!!";
        String string = "";

        try (OutputStream os2 = new FileOutputStream(fileName2)) {
                os2.write(text.getBytes("windows-1251"));
        }

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName2),"windows-1251")) {
            int c;
            while ((c = isr.read()) != -1) {
                string += String.valueOf((char)c);
            }
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName1),"UTF-8")) {
            osw.write(string);
        }
    }

}
