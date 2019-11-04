package ru.stc20.molostvov.lesson02.task03;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * Кастомный демаршал Jackson
 */

public class CustomDeserial extends StdDeserializer<Person> {
    CustomDeserial() {
        this(null);
    }

    private CustomDeserial(Class<?> vc) {
        super(vc);
    }

    /**
     * Переопределение стандартного демаршала Jackson
     * @return - возвращает новый массив Person
     * @throws IOException - может генерировать исключение типа IOException
     */

    @Override
    public Person deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("Name").asText();
        String sex =  node.get("Sex").asText();

        return new Person(name, sex);
    }
}
