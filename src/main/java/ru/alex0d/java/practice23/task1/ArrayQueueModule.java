package ru.alex0d.java.practice23.task1;

public class ArrayQueueModule {
    private static int currentSize = 0;
    private static int maxSize = 10;
    private static Object[] array = new Object[maxSize];

    /**
     * Предусловие: newSize > maxSize
     * Постусловие: array.length' > array.length
     */
    private static void increasemaxSize (int newSize) {
        if (newSize <= maxSize) {
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
    public static void enqueue (Object newElement) {
        if (newElement == null) {
            return;
        }

        if (currentSize + 1 >= maxSize * 0.75) {  // 0.75 - коэффициент заполнения
            increasemaxSize(maxSize*2);
        }

        array[currentSize++] = newElement;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = array[0]
     */
    public static Object element() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize' = currentSize - 1
     * Постусловие: array'[0] != array[0]
     * Постусловие: result = array[0]
     */
    public static Object dequeue() {
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
    public static int size() {
        return currentSize;
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: result = true
     */
    public static boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * Предусловие: currentSize > 0
     * Постусловие: currentSize' = 0
     */
    public static void clear() {
        currentSize = 0;
        maxSize = 10;
        array = new Object[maxSize];
    }

    public static String getString() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < currentSize; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }

}
