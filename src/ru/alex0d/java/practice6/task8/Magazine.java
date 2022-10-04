package ru.alex0d.java.practice6.task8;

import ru.alex0d.java.practice6.task6.Printable;

public class Magazine implements Printable {
    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Журнал " + name);
    }
}
