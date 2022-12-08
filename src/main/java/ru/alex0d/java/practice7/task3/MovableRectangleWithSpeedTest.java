package ru.alex0d.java.practice7.task3;

import ru.alex0d.java.practice7.task1.MovableRectangle;

public class MovableRectangleWithSpeedTest extends MovableRectangle {
    public MovableRectangleWithSpeedTest(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        super(x1, y1, x2, y2, xSpeed, ySpeed);
    }

    public boolean speedTest() {
        return (topLeft.getXSpeed() == bottomRight.getXSpeed()) && (topLeft.getYSpeed() == bottomRight.getYSpeed());
    }
}
