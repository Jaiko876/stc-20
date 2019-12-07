package ru.stc20.molostvov.lesson11;

class GenerationException extends Exception {
    /**
     * Конструктор пользовательского исключения, просто обертка, ничего не делает
      * @param msg - сообщение об ошибке
     */
    GenerationException (String msg) {
        super(msg);
    }
}
