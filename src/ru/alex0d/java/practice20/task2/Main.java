package ru.alex0d.java.practice20.task2;

public class Main {
    public static void main(String[] args) {
        Test<Integer, String, Double> test = new Test<>(1, "2", 3.0);
        test.printTypes();
    }
}
