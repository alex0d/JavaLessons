package ru.alex0d.java.practice2.task6;

import ru.alex0d.java.practice2.task3.Circle;
import ru.alex0d.java.practice2.task3.Point;

public class CircleModel extends Circle {
    public CircleModel(Point center, double r) {
        super(center, r);
    }

    public CircleModel(double x, double y, double r) {
        super(x, y, r);
    }

    public double getArea() {
        return Math.PI * getR() * getR();
    }

    public double getCircumferenceLength() {
        return 2 * Math.PI * getR();
    }

    public boolean equals(CircleModel anotherCircle) {
        return getR() == anotherCircle.getR();
    }
}
