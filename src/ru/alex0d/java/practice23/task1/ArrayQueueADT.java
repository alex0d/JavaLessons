package ru.alex0d.java.practice23.task1;

public class ArrayQueueADT {
    private int currentSize;
    private int maxSize;
    private Object[] array;

    public ArrayQueueADT() {
        currentSize = 0;
        maxSize = 10;
        array = new Object[maxSize];
    }

    /**
     * Предусловие: newSize > maxSize
     * Постусловие: array.length' > array.length
     */
    private static void increasemaxSize(ArrayQueueADT current, int newSize) {
        if (newSize < current.array.length) {
            return;
        }
        current.maxSize = newSize;
        Object[] tmp = new Object[current.maxSize];
        System.arraycopy(current.array, 0, tmp, 0, current.currentSize);
        current.array = tmp;

    }

    /**
     * Предусловие: newElement != null
     * Постусловие: array[currentSize - 1] = element
     * Постусловие: currentSize' = currentSize++
     */
    public static void enqueue(ArrayQueueADT current, Object newElement) {
        if (newElement == null) {
            return;
        }

        if (current.currentSize + 1 >= current.maxSize * 0.75) {  // 0.75 - коэффициент заполнения
            increasemaxSize(current,current.maxSize * 2);
        }

        current.array[current.currentSize++] = newElement;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = array[0]
     */
    public static Object element(ArrayQueueADT current) {
        if (isEmpty(current)) {
            return null;
        }
        return current.array[0];
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize' = currentSize - 1
     * Постусловие: array'[0] != array[0]
     * Постусловие: result = array[0]
     */
    public static Object dequeue(ArrayQueueADT current) {
        if (isEmpty(current)) {
            return null;
        }
        Object[] tmp = new Object[current.maxSize];
        Object firstElement = current.array[0];
        current.currentSize--;
        System.arraycopy(current.array, 1, tmp, 0, current.currentSize);
        current.array = tmp;
        return firstElement;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = currentSize
     */
    public static int size(ArrayQueueADT current) {
        return current.currentSize;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = true
     */
    public static boolean isEmpty(ArrayQueueADT current) {
        return (current.currentSize == 0);
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize = 0
     */
    public static void clear(ArrayQueueADT current) {
        current.currentSize = 0;
        current.maxSize = 10;
        current.array = new Object[current.maxSize];
    }

    public static String getString(ArrayQueueADT current) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < current.currentSize; i++) {
            result.append(current.array[i]).append(" ");
        }
        return result.toString();
    }

}

