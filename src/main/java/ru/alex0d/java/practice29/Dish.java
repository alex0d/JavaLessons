package ru.alex0d.java.practice29;

import java.util.Objects;

public final class Dish implements Item {
    private final int price;
    private final String name;
    private final String description;


    Dish(int price, String name, String description) {
        if (description.isEmpty() || price < 0 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.description = description;
        this.price = price;
        this.name = name;

    }

    @Override
    public int getCost() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Dish other = (Dish) obj;
        return this.price == other.price &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, description);
    }

    @Override
    public String toString() {
        return "Dish[" +
                "price=" + price + ", " +
                "name=" + name + ", " +
                "description=" + description + ']';
    }
}
