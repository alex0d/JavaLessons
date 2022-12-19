package ru.alex0d.java.practice4_1;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        color = "transparent";
        filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor( String color ) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled( boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();
    abstract public double getPerimeter();
    public abstract String toString();

}
