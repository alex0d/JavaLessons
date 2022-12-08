package ru.alex0d.java.practice20.task4;

public class Main {
    public static void main(String[] args) {
        MinMax<Integer> minMax = new MinMax<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println("Min: " + minMax.min());
        System.out.println("Max: " + minMax.max());
        System.out.println();

        int a = 255;
        double b = 3.14;
        System.out.println("Calculator sum: " + Calculator.sum(a, b));
        System.out.println("Calculator multiply: " + Calculator.multiply(a, b));
        System.out.println("Calculator divide: " + Calculator.divide(a, b));
        System.out.println("Calculator subtraction: " + Calculator.subtraction(a, b));
    }
}
