package ru.alex0d.java.practice4_1;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle("red", true, 10);

        System.out.println("С использованием Shape: ");
        System.out.println(".toString: " + shape);
        System.out.println(".getArea: " + shape.getArea());
        System.out.println(".getPerimeter: " + shape.getPerimeter());
        System.out.println(".getColor: " + shape.getColor());
        System.out.println(".isFilled: " + shape.isFilled());

        Circle circle = (Circle) shape;
        System.out.println("\nС использованием Circle: ");
        System.out.println(".toString: " + circle);
        System.out.println(".getArea: " + circle.getArea());
        System.out.println(".getPerimeter: " + circle.getPerimeter());
        System.out.println(".getColor: " + circle.getColor());
        System.out.println(".isFilled: " + circle.isFilled());
        System.out.println(".getRadius: " + circle.getRadius());
    }
}
