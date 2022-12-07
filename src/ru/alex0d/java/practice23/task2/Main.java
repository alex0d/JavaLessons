package ru.alex0d.java.practice23.task2;

public class Main {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        ArrayQueue arrayQueue = new ArrayQueue();

        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
            arrayQueue.enqueue(i);
        }

        System.out.println("LinkedQueue");
        System.out.println("Array before: " + linkedQueue.getString());
        linkedQueue.enqueue(101);
        System.out.println(".dequeue: " + linkedQueue.dequeue());
        System.out.println(".element: " + linkedQueue.element());
        System.out.println(".size: " + linkedQueue.size());
        System.out.println("Array after: " + linkedQueue.getString());

        System.out.println();

        System.out.println("ArrayQueue");
        System.out.println("Array before: " + arrayQueue.getString());
        arrayQueue.enqueue(101);
        System.out.println(".dequeue: " + arrayQueue.dequeue());
        System.out.println(".element: " + arrayQueue.element());
        System.out.println(".size: " + arrayQueue.size());
        System.out.println("Array after: " + arrayQueue.getString());
    }
}
