package ru.molostvov.task17;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1234;

    private String bookName;
    private String autor;
    private int year;


    public Book(String bookName, String autor, int year) {
        this.bookName = bookName;
        this.autor = autor;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                '}';
    }
}
