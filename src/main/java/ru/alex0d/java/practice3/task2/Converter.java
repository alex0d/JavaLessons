package ru.alex0d.java.practice3.task2;

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите валюту, которую хотите конвертировать (USD, EUR, RUB, GBP): ");
        String currency = scanner.next();

        System.out.print("Введите сумму в выбранной валюте: ");
        double amount = scanner.nextDouble();

        System.out.println("Доллар: " + convert(amount, currency, "USD"));
        System.out.println("Евро: " + convert(amount, currency, "EUR"));
        System.out.println("Рубль: " + convert(amount, currency, "RUB"));
        System.out.println("Фунт стерлингов: " + convert(amount, currency, "GBP"));
    }

    public static double convert(double amount, String from, String to) {
        double result = 0;
        double usd = 1;  // Грязная зелёная бумажка
        double eur = 0.9;  // Европейское
        double rub = 70;  // РОССИЯ! РОССИЯ! РОССИЯ!
        double gbp = 0.8;  // Британское
        switch (from) {
            case "USD":
                result = switch (to) {
                    case "EUR" -> amount * usd / eur;
                    case "RUB" -> amount * usd * rub;
                    case "GBP" -> amount * usd / gbp;
                    default -> amount;
                };
                break;
            case "EUR":
                result = switch (to) {
                    case "USD" -> amount * eur / usd;
                    case "RUB" -> amount * eur * rub;
                    case "GBP" -> amount * eur / gbp;
                    default -> amount;
                };
                break;
            case "RUB":
                result = switch (to) {
                    case "USD" -> amount / rub / usd;
                    case "EUR" -> amount / rub / eur;
                    case "GBP" -> amount / rub / gbp;
                    default -> amount;
                };
                break;
            case "GBP":
                result = switch (to) {
                    case "USD" -> amount * gbp / usd;
                    case "EUR" -> amount * gbp / eur;
                    case "RUB" -> amount * gbp * rub;
                    default -> amount;
                };
                break;
        }
        return result;
    }
}
