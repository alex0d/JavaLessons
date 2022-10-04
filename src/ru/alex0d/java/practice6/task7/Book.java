package ru.alex0d.java.practice6.task7;

import ru.alex0d.java.practice6.task6.Printable;

public class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году\n", name, author, year);
    }
}
