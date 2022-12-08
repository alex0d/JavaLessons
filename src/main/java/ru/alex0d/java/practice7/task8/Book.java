package ru.alex0d.java.practice7.task8;

import ru.alex0d.java.practice6.task6.Printable;

public class Book extends ru.alex0d.java.practice6.task7.Book {
    public Book(String name, String author, int year) {
        super(name, author, year);
    }

    public static void printBooks(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                printable.print();
            }
        }
    }
}
