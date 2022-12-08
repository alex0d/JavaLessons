package ru.alex0d.java.practice21.task3;

public class Main {
    public static void main(String[] args) {
        GenericArray genericArray = new GenericArray(new Object[]{1, 2.5, "abc", 4, 5.555});
        int a = genericArray.<Integer>getByIndex(0);
        double b = genericArray.<Double>getByIndex(1);
        String c = genericArray.<String>getByIndex(2);

        System.out.println("" + a + " " + b + " " + c);
    }
}
