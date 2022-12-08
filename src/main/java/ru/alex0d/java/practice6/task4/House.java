package ru.alex0d.java.practice6.task4;

public class House implements Priceable {
    private String address;
    private int price;

    public House(String address, int price) {
        this.address = address;
        this.price = price;
    }

    @Override
    public String toString() {
        return "House: " + address;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
