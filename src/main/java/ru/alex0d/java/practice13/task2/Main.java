package ru.alex0d.java.practice13.task2;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", "Иван", "Иванович");
        System.out.println(person1.getSurnameNP());

        Person person2 = new Person("Петров", "Петр");
        System.out.println(person2.getSurnameNP());

        Person person3 = new Person("Сидоров");
        System.out.println(person3.getSurnameNP());
    }
}
