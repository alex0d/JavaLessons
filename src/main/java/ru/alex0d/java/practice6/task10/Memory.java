package ru.alex0d.java.practice6.task10;

import ru.alex0d.java.practice6.task4.Priceable;
import ru.alex0d.java.practice6.task6.Printable;

public class Memory implements Priceable, Printable {
    private String name;
    private int capacity;
    private int price;

    public Memory(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Оперативная память " + name + " " + capacity + " Гб");
    }
}
