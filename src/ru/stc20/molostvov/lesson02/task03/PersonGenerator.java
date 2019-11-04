package ru.stc20.molostvov.lesson02.task03;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;

/**
 * Класс содержит генератор массива объектов типа Person
 */

class PersonGenerator {
    /**
     * Метод генерирует массив Person
     * @return - возвращает массив Person
     */
    static Person[] generate() {
        Person[] persons = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Person.class, new CustomDeserial());
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, false);
        File file = new File("src/ru/stc20/molostvov/lesson02/task03/russian_names.json");
        try {
            persons = objectMapper.readValue(file, Person[].class);
            int counter = 0;
            for (Person person: persons) {
                ++counter;
            }
            System.out.println("Инициализирован массив состоящий из " + counter + " Person");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
