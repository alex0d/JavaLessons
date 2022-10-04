package ru.alex0d.java.practice6.task10;

import ru.alex0d.java.practice6.task4.Priceable;
import ru.alex0d.java.practice6.task6.Printable;

public class Monitor implements Priceable, Printable {
    private String name;
    private int diagonal;
    private int price;

    public Monitor(String name, int diagonal, int price) {
        this.name = name;
        this.diagonal = diagonal;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Монитор " + name + " " + diagonal + "''");
    }
}
