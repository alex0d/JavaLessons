package ru.alex0d.java.practice13.task4;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public Shirt(String shirtString) {
        String[] shirtStringParts = shirtString.split(",");
        this.id = shirtStringParts[0];
        this.description = shirtStringParts[1];
        this.color = shirtStringParts[2];
        this.size = shirtStringParts[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
