package ru.alex0d.java.practice4.task4;

public class Computer {
    private String name;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(String name, Processor processor, Memory memory, Monitor monitor) {
        this.name = name;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", processor=" + processor +
                ", memory=" + memory +
                ", monitor=" + monitor +
                '}';
    }
}
