package ru.stc20.molostvov.lesson06.task02;

/**
 * Обертка для исключения
 * @author Игорь Молоствов
 */
public class GenException extends Exception {
    GenException(String msg) {
        super(msg);
    }
}
