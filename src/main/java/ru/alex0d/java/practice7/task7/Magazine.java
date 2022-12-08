package ru.alex0d.java.practice7.task7;

import ru.alex0d.java.practice6.task6.Printable;

public class Magazine extends ru.alex0d.java.practice6.task8.Magazine {
    public Magazine(String name) {
        super(name);
    }

    public static void printMagazines(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Magazine) {
                printable.print();
            }
        }
    }
}
