package ru.alex0d.java.practice13.task3;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Россия, Московская область, Москва, Ленина, 1, 1, 1", 0);
        System.out.println("Splited by comma: ");
        System.out.println(address1);

        Address address2 = new Address("Россия; Московская область; Москва; Ленина; 1; 1; 1", 1);
        System.out.println("\nSplited by semicolon: ");
        System.out.println(address2);
    }
}
