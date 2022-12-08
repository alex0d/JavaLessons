package ru.alex0d.java.practice20.task4;

public class MinMax<E extends Comparable>{
    private E[] array;

    public MinMax(E[] array) {
        this.array = array;
    }

    public E min() {
        E minElement = array[0];
        for (E e : array) {
            if (e.compareTo(minElement) < 0) {
                minElement = e;
            }
        }
        return minElement;
    }

    public E max(){
        E maxElement = array[0];
        for (E e : array) {
            if (e.compareTo(maxElement) > 0) {
                maxElement = e;
            }
        }
        return maxElement;
    }
}
