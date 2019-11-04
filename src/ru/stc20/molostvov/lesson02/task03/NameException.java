package ru.stc20.molostvov.lesson02.task03;

class NameException extends Exception {
    private static int i;
    /**
     * Пользовательское исключение, добавляет число в конец имени при совпадении пола, возраста и имени пользователя
     * с другим.
     * @param person - принимает объект типа Person
     */
    NameException(Person person) {
        System.out.println("Ошибка! Повторяющееся имя. Имя пользователя было изменено!");
        person.setName(person.getName()+ i);
        i++;
    }
}
