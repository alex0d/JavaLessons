package ru.alex0d.java.practice7.task6;

import ru.alex0d.java.practice7.task5.ProcessStringInterface;

public class Main {
    public static void main(String[] args) {
        ProcessStringInterface process = new ProcessString("Hello, world!");
        System.out.println(process.countChars());
        System.out.println(process.replaceInOdd());
        System.out.println(process.invert());
    }
}
