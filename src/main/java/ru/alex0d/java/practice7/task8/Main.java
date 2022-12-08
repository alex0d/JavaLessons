package ru.alex0d.java.practice7.task8;

import ru.alex0d.java.practice6.task6.Printable;
import ru.alex0d.java.practice7.task7.Magazine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Printable> printables = new ArrayList<>();

        printables.add(new Book("Война и мир", "Лев Толстой", 1869));
        printables.add(new Book("Отцы и дети", "Иван Тургенев", 1862));
        printables.add(new Book("Чайка", "Антон Чехов", 1896));
        printables.add(new Magazine("Компьютерная графика"));
        printables.add(new Magazine("Компьютерные технологии"));
        printables.add(new Magazine("Программист"));

        System.out.println("Книги:");
        Book.printBooks(printables.toArray(new Printable[0]));


        System.out.println("\nЖурналы:");
        Magazine.printMagazines(printables.toArray(new Printable[0]));
    }
}