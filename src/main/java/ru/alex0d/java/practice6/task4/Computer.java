package ru.alex0d.java.practice6.task4;

public class Computer implements Priceable {
    private String name;
    private int price;

    public Computer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer: " + name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
