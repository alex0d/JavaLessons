package ru.alex0d.java.practice23.task1;

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        ArrayQueueADT queueADT = new ArrayQueueADT();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            ArrayQueueADT.enqueue(queueADT, i);
            ArrayQueueModule.enqueue(i);
        }

        System.out.println("ArrayQueue");
        System.out.println("Array before: " + queue.getString());
        queue.enqueue(101);
        System.out.println(".dequeue: " + queue.dequeue());
        System.out.println(".element: " + queue.element());
        System.out.println(".size: " + queue.size());
        System.out.println("Array after: " + queue.getString());

        System.out.println();

        System.out.println("ArrayQueueADT");
        System.out.println("Array before: " + ArrayQueueADT.getString(queueADT));
        ArrayQueueADT.enqueue(queueADT, 101);
        System.out.println(".dequeue: " + ArrayQueueADT.dequeue(queueADT));
        System.out.println(".element: " + ArrayQueueADT.element(queueADT));
        System.out.println(".size: " + ArrayQueueADT.size(queueADT));
        System.out.println("Array after: " + ArrayQueueADT.getString(queueADT));

        System.out.println();

        System.out.println("ArrayQueueModule");
        System.out.println("Array before: " + ArrayQueueModule.getString());
        ArrayQueueModule.enqueue(101);
        System.out.println(".dequeue: " + ArrayQueueModule.dequeue());
        System.out.println(".element: " + ArrayQueueModule.element());
        System.out.println(".size: " + ArrayQueueModule.size());
        System.out.println("Array after: " + ArrayQueueModule.getString());
    }
}
