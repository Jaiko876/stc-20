package ru.stc20.molostvov.lesson09;

import java.io.*;
import java.nio.file.Files;

/**
 * Кастомный ClassLoader
 * @author Игорь Молоствов
 */

public class MyClassLoader extends ClassLoader {
    /**
     * Переопределение метода findClass
     * @param name - имя класса
     * @return - возвращает класс
     * @throws ClassNotFoundException - исключение, если класс не найден
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(name+".class");
        if(!f.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        try{
            byte[] b = Files.readAllBytes(f.toPath());
            return defineClass(null, b, 0, b.length);
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
    }
}
