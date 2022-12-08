package ru.alex0d.java.practice20.task3;

public class Main {
    public static void main(String[] args) {
        Test<Comparable<String>, SerializableAnimal, Integer> test = new Test<>(new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        }, new SerializableAnimal("Cat"), 1);
        test.printTypes();
    }
}
