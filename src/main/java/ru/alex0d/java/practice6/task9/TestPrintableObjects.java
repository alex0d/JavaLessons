package ru.alex0d.java.practice6.task9;

import ru.alex0d.java.practice6.task6.Printable;
import ru.alex0d.java.practice6.task7.Book;
import ru.alex0d.java.practice6.task8.Magazine;

public class TestPrintableObjects {
    public static void main(String[] args) {
        Printable[] printables = new Printable[3];
        printables[0] = new Book("Война и мир", "Лев Толстой", 1869);
        printables[1] = new Book("Преступление и наказание", "Федор Достоевский", 1866);
        printables[2] = new Magazine("Компьютерный журнал");

        for (Printable printable : printables) {
            printable.print();
        }
    }
}
