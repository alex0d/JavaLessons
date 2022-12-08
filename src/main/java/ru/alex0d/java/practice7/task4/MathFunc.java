package ru.alex0d.java.practice7.task4;

public class MathFunc implements MathCalculable {
    @Override
    public double power(double a, double p) {
        return Math.pow(a, p);
    }

    @Override
    public double complex_modulus(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }
}
