package ru.alex0d.java.practice21.task3;

public class GenericArray extends ru.alex0d.java.practice21.task2.GenericArray {
    public GenericArray(Object[] array) {
        super(array);
    }

    public <E> E getByIndex(int index) {
        return (E) super.getArray()[index];
    }
}
