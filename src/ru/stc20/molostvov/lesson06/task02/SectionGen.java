package ru.stc20.molostvov.lesson06.task02;

import java.util.Random;

/**
 * Класс генерирует абзацы из которых генерируется текст.
 * @author Игорь Молоствов
 */

public class SectionGen extends SentenceGen{
    /**
     * Метод создаёт один абзац.
     * @param words - массив слов.
     * @param size - оставшееся количество байт для генерации.
     * @param probability - шанс включения слова в предложение?
     * @return - возвращает строку-абзац.
     */
    protected String makeSection(String[] words, int size, int probability) {
        Random random = new Random(System.nanoTime());
        StringBuilder sb = new StringBuilder();
        int currentSize;
        int sectionSize = random.nextInt(20-1) + 1;
        for (int i = 0; i < sectionSize; i++) {
            currentSize = size - getSize(sb.toString());
            if (currentSize <= 1) {
                return sb.toString();
            }
            if (i == 0) {
                sb.append(makeSentence(true,false, words, currentSize, probability));
            } else {
                if (i + 1 == sectionSize) {
                    sb.append(makeSentence(false,true, words, currentSize, probability));
                } else {
                    sb.append(makeSentence(false, false, words, currentSize, probability));
                }
            }
        }
        return sb.toString();
    }
}
