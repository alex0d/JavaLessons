package ru.alex0d.java.practice23.task2;

import java.util.LinkedList;

public class LinkedQueue extends AbstractQueue {
    private LinkedList<Object> linkedQueue = new LinkedList<>();

    @Override
    public void enqueue(Object element) {
        linkedQueue.add(element);
    }

    @Override
    public Object element() {
        return linkedQueue.peekFirst();
    }

    @Override
    public Object dequeue() {
        return linkedQueue.pollFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedQueue.isEmpty();
    }

    @Override
    public void clear() {
        linkedQueue.clear();
    }

    @Override
    public String getString() {
        return linkedQueue.toString();
    }

    @Override
    public int size() {
        return linkedQueue.size();
    }
}
