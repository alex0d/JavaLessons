package ru.alex0d.java.practice6.task10;

import ru.alex0d.java.practice6.task4.Priceable;
import ru.alex0d.java.practice6.task6.Printable;

public class Processor implements Priceable, Printable {
    private String name;
    private int cores;
    private double frequency;
    private int price;

    public Processor(String name, int cores, double Ghz, int price) {
        this.name = name;
        this.cores = cores;
        this.frequency = Ghz;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Процессор " + name + " с " + cores + " ядрами и частотой " + frequency + " ГГц");
    }
}
