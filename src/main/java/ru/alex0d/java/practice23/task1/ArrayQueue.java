package ru.alex0d.java.practice23.task1;

public class ArrayQueue {
    private int currentSize;
    private int maxSize;
    private Object[] array;


    public ArrayQueue() {
        currentSize = 0;
        maxSize = 10;
        array = new Object[maxSize];
    }

    /**
     * Предусловие: newSize > maxSize
     * Постусловие: array.length' > array.length
     */
    private void increasemaxSize(int newSize) {
        if (newSize < array.length) {
            return;
        }
        maxSize = newSize;
        Object[] tmp = new Object[maxSize];
        System.arraycopy(array, 0, tmp, 0, currentSize);
        array = tmp;
    }


    /**
     * Предусловие: newElement != null
     * Постусловие: array[currentSize - 1] = element
     * Постусловие: currentSize' = currentSize++
     */
    public void enqueue(Object newElement) {
        if (newElement == null) {
            return;
        }
        if (currentSize + 1 >= maxSize * 0.75) {
            increasemaxSize(maxSize*2);
        }

        array[currentSize++] = newElement;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = array[0]
     */
    public Object element() {
        if(isEmpty()) return null;
        return array[0];
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize' = currentSize - 1
     * Постусловие: array'[0] != array[0]
     */
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object[] tmp = new Object[maxSize];
        Object firstElement = array[0];
        currentSize--;
        System.arraycopy(array, 1, tmp, 0, currentSize);
        array = tmp;
        return firstElement;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = currentSize
     */
    public int size() {
        return currentSize;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = true
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize' = 0
     */
    public void clear() {
        currentSize = 0;
        maxSize = 8;
        array = new Object[maxSize];
    }


    public String getString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currentSize; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }
}
