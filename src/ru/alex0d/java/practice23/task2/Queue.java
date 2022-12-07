package ru.alex0d.java.practice23.task2;

public interface Queue {
    void enqueue(Object element);
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
    String getString();
}