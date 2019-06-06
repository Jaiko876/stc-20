package ru.molostvov.task20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        RussianCallendar russianCallendar;

        try {
            URL url = new URL("https://datazen.katren.ru/calendar/day/");

            try (InputStreamReader isr = new InputStreamReader(url.openStream())) {
                ObjectMapper mapper = new ObjectMapper();
                russianCallendar = mapper.readValue(isr, RussianCallendar.class);
                System.out.printf("Сегодня праздник: %b\nДата: %tD\n", russianCallendar.isHoliday()
                        ,russianCallendar.getDate());
            }
        } catch (IOException e){
            System.out.println("Ошибка!");
        }
    }
}
