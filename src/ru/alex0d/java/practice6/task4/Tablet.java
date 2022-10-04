package ru.alex0d.java.practice6.task4;

public class Tablet implements Priceable {
    private String name;
    private int price;

    public Tablet(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tablet: " + name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
