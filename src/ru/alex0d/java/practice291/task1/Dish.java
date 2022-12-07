package ru.alex0d.java.practice291.task1;

import ru.alex0d.java.practice291.task2.Item;

public final class Dish implements Item {
    private final int cost;
    private final String name;
    private final String description;

    public Dish(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
