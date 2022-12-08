package ru.alex0d.java.practice23.task2;

import java.util.ArrayList;

public class ArrayQueue extends AbstractQueue {
    private ArrayList<Object> arrayQueue = new ArrayList<>();

    @Override
    public void enqueue(Object element) {
        arrayQueue.add(element);
    }

    @Override
    public Object element() {
        return arrayQueue.get(0);
    }

    @Override
    public Object dequeue() {
        return arrayQueue.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    @Override
    public void clear() {
        arrayQueue.clear();
    }

    @Override
    public String getString() {
        return arrayQueue.toString();
    }

    @Override
    public int size() {
        return arrayQueue.size();
    }
}
