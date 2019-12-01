package ru.stc20.molostvov.lesson06.task02;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Класс генерирует предложение.
 * @author Игорь Молоствов
 */

public class SentenceGen {
    private List<Character> endingChars = new ArrayList<>();
    private List<Character> spacingChars = new ArrayList<>();

    SentenceGen() {
        endingChars.add('.');
        endingChars.add('!');
        endingChars.add('?');

        spacingChars.add(' ');
        spacingChars.add(',');
    }

    /**
     * Метод создаёт одно предложение для будущего абзаца.
     * @param firstInParagraph - предложение первое в абзаце?
     * @param lastSentence - последнее предложение?
     * @param words - массив слов.
     * @param size - оставшееся количество байт для генерации.
     * @param probability - шанс вхождения слова в предложение?
     * @return - возвращает строку - предложение.
     */
    protected String makeSentence(boolean firstInParagraph, boolean lastSentence, String[] words,
                                  int size, int probability) {
        Random random = new Random(System.nanoTime());
        int chanceOfSymbol;
        int indexOfWord;
        StringBuilder sb = new StringBuilder();
        StringBuilder end = new StringBuilder();
        int amountWordsInSentence = random.nextInt(15-1) + 1;

        for (int counter = 0; counter < amountWordsInSentence; ) {
            indexOfWord = random.nextInt(words.length);
            if (Math.random() < 1.0 / probability) {
                if (counter == 0) {
                    sb.append(words[indexOfWord]);
                    char upper = Character.toUpperCase(sb.charAt(0));
                    sb.setCharAt(0,upper);
                    if (firstInParagraph) {
                        sb.insert(0,' ');
                        firstInParagraph = false;
                    }
                } else {
                    sb.append(words[indexOfWord]);
                }
                if (counter + 1 == amountWordsInSentence) {
                    sb.append(endingChars.get(random.nextInt(3)));
                    if (lastSentence) {
                        sb.append("\r\n");
                        break;
                    } else {
                        sb.append(spacingChars.get(0));
                    }
                } else {
                    chanceOfSymbol = random.nextInt(100);
                    if (chanceOfSymbol < 80){
                        sb.append(spacingChars.get(0));
                    } else {
                        sb.append(spacingChars.get(1));
                        sb.append(spacingChars.get(0));
                    }
                }
                // Условие обрубает слово, ставит последний знак, делает \r\n, если достигнут допустимый размер.
                if (getSize(sb.toString()) >= size) {
                    while (getSize(sb.toString()) + 3 > size && size >= 3) {
                        sb.setLength(sb.toString().length() - 1);
                    }
                    end.append(endingChars.get(random.nextInt(3)));
                    end.append("\r\n");
                    sb.replace(sb.toString().length(),sb.toString().length(), end.toString());
                    return sb.toString();
                }
                counter++;
            }
        }
        return sb.toString();
    }

    /**
     * Метод возвращает размер строки в байтах.
     * @param str - строка.
     * @return - размер строки.
     */
    protected int getSize(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }
}
