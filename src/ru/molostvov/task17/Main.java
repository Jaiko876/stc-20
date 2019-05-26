package ru.molostvov.task17;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static String FILENAME = "Library.bin";

    public static void main(String[] args) {

        Book book = new Book("Книга1","Автор1",1994);
        Book book2 = new Book("Книга2","Автор2",1912);
        Book book3 = new Book("Книга3","Автор31",1923);
        Book book4 = new Book("Книга4","Автор41",1494);


        openLibrary();
        saveBooks(book,book3);
        openLibrary();
        saveBooks(book2);
        openLibrary();

    }

    private static void saveBooks(Book ... books) {
        if (books.length != 0) {
            File file = new File(FILENAME);
            if (file.exists()) {
                try (ObjectOutputStream oos = new AppendingObjectOutputStream(new FileOutputStream(file,true))
                ) {
                    LOGGER.info("Добавляем книгу(и) в библиотеку!");
                    for (Book book : books) {
                        oos.writeObject(book);
                    }
                    LOGGER.info("Успешно!");
                } catch (IOException e) {
                    LOGGER.error("Ошибка при записи в файл!", e);
                }
            } else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
                    LOGGER.info("Добавляем книгу(и) в библиотеку!");
                    for (Book book: books) {
                        oos.writeObject(book);
                    }
                    LOGGER.info("Успешно!");
                } catch (IOException e) {
                    LOGGER.error("Ошибка при записи в файл!", e);
                }
            }
        }
    }

    private static void openLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))
        ) {
            LOGGER.info("Выводим список книг в библиотеке");
            while (true) {
                System.out.println(ois.readObject());
           }
        } catch (EOFException e) {
            LOGGER.info("Конец файла!");
            System.out.println("------------------------------------");
        } catch (IOException e) {
            LOGGER.info("В библиотеке нет книг!");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Ошибка",e);
        }
    }
}
