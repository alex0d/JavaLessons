package ru.alex0d.java.practice11.task5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < 100000; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        arrayList.add(12345);
        System.out.println("Add in ArrayList: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        arrayList.add(50000, 12345);
        System.out.println("Add in ArrayList by index: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        arrayList.remove(50000);
        System.out.println("Remove from ArrayList by index: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        arrayList.indexOf(50000);
        System.out.println("Get index from ArrayList: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        linkedList.add(12345);
        System.out.println("\nAdd in LinkedList: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        linkedList.add(50000, 12345);
        System.out.println("Add in LinkedList by index: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        linkedList.remove(50000);
        System.out.println("Remove from LinkedList by index: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        linkedList.indexOf(50000);
        System.out.println("Get index from LinkedList: " + (System.nanoTime() - start) + " ns");
    }
}
