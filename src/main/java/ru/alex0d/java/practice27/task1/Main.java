package ru.alex0d.java.practice27.task1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        set = new TreeSet<>(set);
        System.out.println(set);
    }
}
