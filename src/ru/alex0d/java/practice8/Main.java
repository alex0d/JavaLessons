package ru.alex0d.java.practice8;

import java.util.Scanner;

public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("15. Задание: цифры числа справа налево");
        printDigitsInReverseOrder(123456789);

        System.out.println("\n16. Задание: количество элементов, равных максимальному");
        System.out.println("Введите последовательность чисел (0 - завершение): ");
        int[] pair = countMaxElements(new int[]{Integer.MIN_VALUE, 0});
        System.out.println("Максимальный элемент последовательности: " + pair[0]);
        System.out.println("Количество максимальных элементов: " + pair[1]);

        System.out.println("\n8. Задание Палиндром");
        String palindrome = "aabcbaa";
        System.out.println("Строка \"" + palindrome + "\" является палиндромом: " + isPalindrome(palindrome));

        System.out.println("\n9. Задание: без двух нулей.");
        System.out.println(countSequences(5, 5));

        System.out.println("\n11. Задание: количество единиц.");
        System.out.println("Введите последовательность чисел (0 0 - завершение): ");
        System.out.println("Количество единиц: " + countOnes(-1, 0));
    }

    /**
     * 15. Задание: цифры числа справа налево.
     * Дано натуральное число. Вывести на экран все цифры, входящие в его состав, в обратном порядке.
     * @param n число
     */
    public static void printDigitsInReverseOrder(int n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            System.out.print((n % 10) + " ");
            printDigitsInReverseOrder(n / 10);
        }
    }

    /**
     * 16. Задание: количество элементов, равных максимальному.
     * Дана последовательность натуральных чисел, завершающаяся числом 0.
     * Определите количество наибольших элементов последовательности.
     * @param pair массив из двух элементов: максимальный элемент и количество максимальных элементов
     * @return массив из двух элементов: максимальный элемент и количество максимальных элементов
     */
    public static int[] countMaxElements(int[] pair) {
        int nextInt = sc.nextInt();

        if (nextInt == 0) {
            return pair;
        }

        if (nextInt > pair[0]) {
            pair[0] = nextInt;
            pair[1] = 1;
        } else if (nextInt == pair[0]) {
            pair[1]++;
        }
        return countMaxElements(pair);
    }

    /**
     * 8. Задание Палиндром.
     * Дано слово, состоящее только из строчных латинских букв.
     * Проверьте, является ли это слово палиндромом.
     * @param str слово
     * @return true, если слово является палиндромом, иначе false
     */
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    /**
     * 9. Задание: без двух нулей.
     * Даны числа a и b.
     * Определите, сколько существует последовательностей из a нулей и b единиц,
     * в которых никакие два нуля не стоят рядом.
     * @param a количество нулей
     * @param b количество единиц
     * @return количество последовательностей
     */
    public static int countSequences(int a, int b) {
        if (a == 0) {
            // Все единицы
            return 1;
        }
        if (a == 1) {
            // Один нуль и все единицы
            return b + 1;
        }
        if (a > 1 && b == 0) {
            // Больше одного нуля и нет единиц
            return 0;
        }
        // Иначе последовательность окончивается либо на 10, либо на 1
        return countSequences(a - 1, b - 1) + countSequences(a, b - 1);
    }

    /**
     * 11. Задание: количество единиц.
     * Вводится последовательность натуральных чисел, завершающаяся двумя числами 0 подряд.
     * Определите количество чисел, равных 1.
     * @param prevInt предыдущее число
     * @param count количество единиц
     * @return количество единиц
     */
    public static int countOnes(int prevInt, int count) {
        int nextInt = sc.nextInt();
        if (prevInt == 0 && nextInt == 0) {
            return count;
        }
        if (nextInt == 1) {
            return countOnes(nextInt, count + 1);
        }
        return countOnes(nextInt, count);
    }

}
