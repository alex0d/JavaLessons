package ru.alex0d.java.l220915.task4;

public class Computer {
    private String name;

    public Computer(String description) {
        this.name = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                '}';
    }
}
