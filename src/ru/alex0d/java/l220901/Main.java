package ru.alex0d.java.l220901;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        System.out.println(sum);

        sum = 0;
        int i = 0;
        while (i < n) {
            sum += array[i];
            i++;
        }
        System.out.println(sum);

        sum = 0;
        i = 0;
        do {
            sum += array[i];
            i++;
        } while (i < n);
        System.out.println(sum);
    }

    public static void task2() {
        float sum = 0;
        for (int i = 1; i <= 10; i++) {
            float f = 1f / i;
            System.out.format("%.2f\n", f);
            sum += f;
        }
        System.out.print("Sum: ");
        System.out.format("%.2f", sum);
    }

    public static void task3() {
        ArrayList<Integer> arr = new ArrayList<>(10);
        Random random = new Random(245);
        for (int i = 0; i < 10; i++) {
            arr.add(random.nextInt(-100, 100));
        }
        System.out.println("Random: " + arr);

        Collections.sort(arr);
        System.out.println("Sorted: " + arr);

        for (int i = 0; i < 10; i++) {
            arr.set(i, (int) (Math.random() * 100 - 50));
        }
        System.out.println("Math.random: " + arr);

        Collections.sort(arr);
        System.out.println("Sorted: " + arr);
    }
}
