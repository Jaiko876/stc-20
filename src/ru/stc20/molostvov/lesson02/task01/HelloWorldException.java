package ru.stc20.molostvov.lesson02.task01;

class HelloWorldException extends Exception {
    /**
     * HelloWorldException генерирует новое исключение и содержит в себе подробное сообщение об ошибке,
     * которое обрабатывается родителем класса.
     * @param msg детальное сообщение об ошибке.
     */
    HelloWorldException(String msg) {
        super(msg);
    }
}
