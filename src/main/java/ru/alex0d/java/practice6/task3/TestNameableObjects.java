package ru.alex0d.java.practice6.task3;

public class TestNameableObjects {
    public static void main(String[] args) {
        Nameable[] nameables = new Nameable[3];
        nameables[0] = new Animal("Кошка");
        nameables[1] = new Car("Москвич");
        nameables[2] = new Planet("Земля");

        for (Nameable nameable : nameables) {
            System.out.println(nameable.getName());
        }
    }
}
