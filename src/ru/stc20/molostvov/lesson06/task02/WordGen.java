package ru.stc20.molostvov.lesson06.task02;

import java.util.Random;

/**
 * Генератор слов.
 * @author Игорь Молоствов
 */
public class WordGen {
    private final char[] letters = new char[33];

    WordGen() {
        int j = 0;
        for (int i = 1072; i < 1104; i++) {
            letters[j++] = ((char) i);
            //добавляем Ё
            if (i == 1077)
                letters[j++] = ((char) 1105);
        }
    }

    /**
     * Метод генерирует одно слово.
     * @return возвращает строку - слово.
     */
    private String generateWord() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(System.nanoTime());
        int amount = random.nextInt(15 - 1) + 1;
        int randomedLetter;

        for (int i = 0; i < amount ; i++) {
            randomedLetter = random.nextInt(33);
            sb.append(letters[randomedLetter]);
        }
        return sb.toString();
    }

    /**
     * Метод генерирует массив слов.
     * @return возвращает массив строк - слов.
     */
    public String[] generateWordArray() {
        Random random = new Random(System.nanoTime());
        int amountOfWords = random.nextInt(1000-1) + 1;
        String[] words = new String[amountOfWords];
        for (int i = 0; i < amountOfWords ; i++) {
            words[i] = generateWord();
        }
        return words;
    }
}
