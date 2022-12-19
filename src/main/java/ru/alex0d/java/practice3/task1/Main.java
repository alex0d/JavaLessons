package ru.alex0d.java.practice3.task1;

public class Main {
    public static void main(String[] args) {
        Double double1 = Double.valueOf(5.0);
        Double double2 = Double.valueOf(0.1d);
        Double double3 = Double.parseDouble("5.0");

        byte byteValue = double1.byteValue();
        short shortValue = double1.shortValue();
        int intValue = double1.intValue();
        long longValue = double1.longValue();
        float floatValue = double1.floatValue();
        double doubleValue = double1.doubleValue();

        System.out.println(Double.toString(double1));
        System.out.println(double2.toString());
        System.out.println(String.valueOf(double3));
    }
}
