package ru.alex0d.java.practice20.task3;

import ru.alex0d.java.practice6.task3.Animal;

import java.io.Serializable;

public class Test<T extends Comparable, V extends Animal & Serializable, K> {
    private T tObj;
    private V vObj;
    private K kObj;

    public Test(T tObj, V vObj, K kObj) {
        this.tObj = tObj;
        this.vObj = vObj;
        this.kObj = kObj;
    }

    public T gettObj() {
        return tObj;
    }

    public void settObj(T tObj) {
        this.tObj = tObj;
    }

    public V getvObj() {
        return vObj;
    }

    public void setvObj(V vObj) {
        this.vObj = vObj;
    }

    public K getkObj() {
        return kObj;
    }

    public void setkObj(K kObj) {
        this.kObj = kObj;
    }

    public void printTypes(){
        System.out.println("Type of T is " + tObj.getClass().getName());
        System.out.println("Type of V is " + vObj.getClass().getName());
        System.out.println("Type of K is " + kObj.getClass().getName());
    }
}
