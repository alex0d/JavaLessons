package ru.alex0d.java.practice22.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение (пустая строка для выхода): ");

        String expression = scanner.nextLine();
        while (!expression.isEmpty()) {
            Double result = RPNCalculator.calculate(expression);
            if (result != null) {
                System.out.println("Ответ: " + result);
            } else {
                System.out.println("Некорректное выражение");
            }
            System.out.print("Введите выражение (пустая строка для выхода): ");
            expression = scanner.nextLine();
        }
    }
}
