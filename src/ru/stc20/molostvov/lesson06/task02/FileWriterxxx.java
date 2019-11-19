package ru.stc20.molostvov.lesson06.task02;

import java.io.*;
import java.util.List;

/**
 * Класс создаёт файлы со сгенерированным текстом.
 */
public class FileWriterxxx implements TextMaker {
    /**
     * Метод создаёт n файлов размером size в каталоге path.
     * @param path - директория для файлов.
     * @param n - количество файлов.
     * @param size - размер файла в байтах.
     * @param words - массив слов.
     * @param probability - вероятность вхождения слова в предложение?
     * @return возвращает true/false при успехе/неуспехе.
     */
    @Override
    public boolean getFiles(String path, int n, int size, String[] words, int probability) {
        TextGen tg = new TextGen();
        int counter = n;
        new File(path).mkdirs();
        StringBuilder sb = new StringBuilder(path);
        sb.append("/TextFile");
        sb.append(n);
        sb.append(".txt");

        File name = new File(sb.toString());

        try (OutputStreamWriter osw = new FileWriter(name,true)) {
            List<String> text = tg.generateText(words, size, probability);
            for (String str : text) {
                osw.write(str);
            }
        }catch (GenException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        counter--;
        if (counter != 0) {
            getFiles(path, counter, size, words, probability);
        }
        return true;
    }

}
