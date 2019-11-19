package ru.stc20.molostvov.lesson06.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генерирует текст. Если size < 10, то пробрасывает исключение. Не работает корректно с маленькими значениями.
 * Может генерировать файлы +- байт от size.
 * @author Игорь Молоствов
 */

public class TextGen extends SectionGen {
    /**
     * Метод, генерирующий текст.
     * @param words - массив слов для генерации текста.
     * @param size - размер получаемого файла.
     * @param probability - вероятность записи слова в предложение?
     * @return - возвращает коллекцию абзацев.
     * @throws GenException - исключение при size < 10.
     */
    public List<String> generateText(String[] words, int size, int probability) throws GenException{
        List<String> text = new ArrayList<>();
        int currentSize = size;
        int i = 0;
        if (currentSize < 10) {
            throw new GenException("Слишком маленький размер файла!");
        }
        while (true) {
            if (i > 0) {
                currentSize = currentSize - getSize(text.get(i-1));
            }
            if (currentSize <= 1) {
                return text;
            } else {
                text.add(makeSection(words, currentSize, probability));
                i++;
            }
        }
    }


}
