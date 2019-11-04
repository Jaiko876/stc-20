package ru.stc20.molostvov.lesson02.task01;

import java.util.Arrays;

/**
 * @author Игорь Молоствов
 */
public class HelloWorld {
    /** Поле "Hello World" */
    private String str = null;
    /** Массив строк "Hello World" */
    private String[] strArray = new String[2];
    /** Счетчик */
    private int counter = 0;

    /**
     * Функция устанавливает значение str
     * @param str - строка, которая должна содержать значение "Hello World";
     */
    private void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        while (true) {
            try {
                // Вызов функции equals от null, после переполнение массива
                if (helloWorld.str.equals("Hello World!")) {
                    helloWorld.strArray[helloWorld.counter++] = helloWorld.str;
                }
            } catch (NullPointerException e) {
                e.printStackTrace(System.out);
                helloWorld.str = "Hello World!";
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace(System.out);
                System.out.println(Arrays.toString(helloWorld.strArray));
                break;
            }
        }
        try {
            //Пользовательское исключение
            throw new HelloWorldException("Массив переполнен, программа аварийно завершена!");
        } catch (HelloWorldException e) {
            e.printStackTrace(System.out);
        }
    }
}
