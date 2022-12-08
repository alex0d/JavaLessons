package ru.alex0d.java.practice7.task4;

public class Main {
    public static void main(String[] args) {
        MathCalculable math = new MathFunc();
        System.out.println(math.PI);
        System.out.println(math.power(2, 3));
        System.out.println(math.complex_modulus(3, 4));
    }
}
