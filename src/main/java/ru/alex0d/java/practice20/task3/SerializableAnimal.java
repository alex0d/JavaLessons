package ru.alex0d.java.practice20.task3;

import ru.alex0d.java.practice6.task3.Animal;

public class SerializableAnimal extends Animal implements java.io.Serializable {
    public SerializableAnimal(String name) {
        super(name);
    }
}
